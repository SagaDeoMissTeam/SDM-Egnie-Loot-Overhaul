package net.sdm.sdm_rpg.core.data;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;
import net.sdm.sdm_rpg.core.data.data.DamageGotData;
import net.sdm.sdm_rpg.core.data.data.ItemUseData;
import net.sdm.sdm_rpg.core.data.data.TimeInStructureData;
import net.sdm.sdm_rpg.core.data.data.TotemUseData;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class HistoryList implements INBTSerializable<CompoundTag> {


    public static Map<Date, UUID> PETS_KILL = new HashMap<>();
    public static List<ItemUseData> HISTORY_ITEMS_USE = new ArrayList<>();
    public static List<UUID> HISTORY_ITEMS_USE_UUID = new ArrayList<>();
    public static List<TotemUseData> COUNT_USE_TOTEM_ON_BATTLE = new ArrayList<>();
    public static Map<UUID, List<ItemStack>> COUNT_USE_ITEM_ON_BATTLE = new HashMap<>();
    public static Map<UUID, DamageGotData> COUNT_DAMAGE_GOT_ON_BATTLE = new HashMap<>();
    public static Map<UUID, Integer> COMBO_KILL_ENTITY = new HashMap<>();
    public static Map<UUID, Entity> SEQUENCE_KILL_ENTITY = new HashMap<>();


    public static void clearTotemHistory(){
        if(!COUNT_USE_TOTEM_ON_BATTLE.isEmpty()){
            for (TotemUseData HISTORY : COUNT_USE_TOTEM_ON_BATTLE) {
                if(HISTORY.coolDown.getTime() < new Date(System.currentTimeMillis()).getTime()) COUNT_USE_TOTEM_ON_BATTLE.remove(HISTORY);

                if(COUNT_USE_TOTEM_ON_BATTLE.isEmpty())
                    return;
            }
        }
    }

    public static void putTotemHistory(Player player, long count){
        if(!COUNT_USE_TOTEM_ON_BATTLE.isEmpty()){
            for (TotemUseData HISTORY : COUNT_USE_TOTEM_ON_BATTLE) {
                if(HISTORY.player == player.getUUID()) {
                    HISTORY.coolDown = new Date(System.currentTimeMillis() + 10000);
                    HISTORY.count += count;
                    return;
                }
            }

            COUNT_USE_TOTEM_ON_BATTLE.add(new TotemUseData(player,count));
            return;
        } else {
            COUNT_USE_TOTEM_ON_BATTLE.add(new TotemUseData(player,count));
        }
    }


    public static void clearDamageHistory(){
        if(!COUNT_DAMAGE_GOT_ON_BATTLE.isEmpty()){
            for(Map.Entry<UUID, DamageGotData> HISTORY : COUNT_DAMAGE_GOT_ON_BATTLE.entrySet()){
                if(HISTORY.getValue().coolDown.getTime() < new Date(System.currentTimeMillis()).getTime()){
                    COUNT_DAMAGE_GOT_ON_BATTLE.remove(HISTORY.getKey());
                }

                if(COUNT_DAMAGE_GOT_ON_BATTLE.isEmpty())
                    return;
            }
        }
    }

    public static void putDamageHistory(Player player, Entity entity, double damage, Date date){
        if(!COUNT_DAMAGE_GOT_ON_BATTLE.isEmpty()){
            if(COUNT_DAMAGE_GOT_ON_BATTLE.containsKey(player.getUUID())){
                COUNT_DAMAGE_GOT_ON_BATTLE.get(player.getUUID()).damage += damage;
                COUNT_DAMAGE_GOT_ON_BATTLE.get(player.getUUID()).addCoolDown(10000);
            } else {
                COUNT_DAMAGE_GOT_ON_BATTLE.put(player.getUUID(), new DamageGotData(player,entity,damage,null).addCoolDown(10000));
            }
        } else{
            COUNT_DAMAGE_GOT_ON_BATTLE.put(player.getUUID(), new DamageGotData(player,entity,damage,null).addCoolDown(10000));
        }
    }

    public static void clearPetHistory(){
        if(!PETS_KILL.isEmpty()) {
            for (Map.Entry<Date, UUID> HISTORY : PETS_KILL.entrySet()) {
                if ((HISTORY.getKey().getTime()) < (new Date(System.currentTimeMillis()).getTime())) {
                    PETS_KILL.remove(HISTORY.getKey(), HISTORY.getValue());
                }

                if(PETS_KILL.isEmpty())
                    return;
            }
        }
    }


    public static void putItemHistory(Player player, Entity entity, ItemStack itemStack){
        if(!HISTORY_ITEMS_USE.isEmpty()){
            for (ItemUseData data : HISTORY_ITEMS_USE) {
                if (data.player == player.getUUID()) {
                    if (data.entity == entity.getUUID()) {
                        data.addItem(itemStack);
                        data.setCooldown(new Date(System.currentTimeMillis() + 2000));
                        return;
                    } else {
                        HISTORY_ITEMS_USE.remove(data);
                        HISTORY_ITEMS_USE_UUID.remove(player.getUUID());
                        ItemUseData itemUseData = new ItemUseData();
                        itemUseData.setPlayer(player);
                        itemUseData.setEntity(entity);
                        itemUseData.cooldown = new Date(System.currentTimeMillis() + 2000);
                        itemUseData.addItem(itemStack);
                        HISTORY_ITEMS_USE.add(itemUseData);
                        HISTORY_ITEMS_USE_UUID.add(player.getUUID());
                        return;
                    }
                }
            }
        } else {
            ItemUseData itemUseData = new ItemUseData();
            itemUseData.setPlayer(player);
            itemUseData.setEntity(entity);
            itemUseData.cooldown = new Date(System.currentTimeMillis() + 2000);
            itemUseData.addItem(itemStack);
            HISTORY_ITEMS_USE.add(itemUseData);
            HISTORY_ITEMS_USE_UUID.add(player.getUUID());
        }
    }
    public static void clearItemHistory(){
        if(!HISTORY_ITEMS_USE.isEmpty()){
            for (ItemUseData data : HISTORY_ITEMS_USE) {
                if (data.cooldown.getTime() < new Date(System.currentTimeMillis()).getTime() && HISTORY_ITEMS_USE.remove(data))
                    HISTORY_ITEMS_USE_UUID.remove(data.player);

                if(HISTORY_ITEMS_USE.isEmpty())
                    return;
            }
        }
    }

    public static List<Date> getDate(UUID uuid){
        List<Date> list = new ArrayList<>();
        for(Map.Entry<Date, UUID> HISTORY : PETS_KILL.entrySet()){
            if(HISTORY.getValue().equals(uuid)) list.add(HISTORY.getKey());
        }
        return list;
    }

    public static @Nullable UUID getUUID(Date date){
        if(PETS_KILL.containsKey(date)) return PETS_KILL.get(date);
        return null;
    }

    public static void putTimeInStructureData(Player player, Entity entity, ResourceLocation structure, long timeEnd){

    }

    public static void clearTimeInStructureData(){
        if(!LevelInfo.timeInStructureData.isEmpty()){
            for (TimeInStructureData data : LevelInfo.timeInStructureData) {
                if(data.timeStart > data.timeEnd) LevelInfo.timeInStructureData.remove(data);

                if(LevelInfo.timeInStructureData.isEmpty())
                    return;
            }
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
