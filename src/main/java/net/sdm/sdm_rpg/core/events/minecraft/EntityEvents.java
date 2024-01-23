package net.sdm.sdm_rpg.core.events.minecraft;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingUseTotemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.data.*;
import net.sdm.sdm_rpg.core.data.data.TotemUseData;
import net.sdm.sdm_rpg.core.events.lootOverhaul.EntityKillPlayerEvent;
import net.sdm.sdm_rpg.core.events.lootOverhaul.SkeletonsKillByEachOtherEvent;
import net.sdm.sdm_rpg.core.utils.EntityUtils;
import org.jline.utils.Log;

import java.util.Date;
import java.util.UUID;

public class EntityEvents {


    @SubscribeEvent
    public static void onEntityDead(LivingDeathEvent event){
        if(event.getEntity().level().isClientSide) return;
        ServerLevel level = event.getEntity().level().getServer().overworld();
        SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();


        if(event.getSource().getEntity() != null) {
            if(event.getSource().getEntity() instanceof TamableAnimal tamableAnimal){
                HistoryList.PETS_KILL.put(new Date(System.currentTimeMillis()), tamableAnimal.getOwnerUUID());
            }

            if (event.getEntity().getType().equals(EntityType.PLAYER)) {
                event.getSource().getEntity().getPersistentData().putBoolean("killPlayer", true);
                MinecraftForge.EVENT_BUS.register(new EntityKillPlayerEvent((LivingEntity) event.getSource().getEntity(), (Player) event.getEntity()));
            }

            if (event.getEntity().getType().equals(EntityType.SKELETON) && event.getSource().getEntity().getType().equals(EntityType.SKELETON)) {
                if (!data.getData().contains("countSkeletonsKillByEachOther")) {
                    data.getData().putInt("countSkeletonsKillByEachOther", 1);
                    LevelInfo.countSkeletonsKillByEachOther = 1;
                } else {
                    data.getData().putInt("countSkeletonsKillByEachOther", data.getData().getInt("countSkeletonsKillByEachOther") + 1);
                    LevelInfo.countSkeletonsKillByEachOther++;
                }
                MinecraftForge.EVENT_BUS.register(new SkeletonsKillByEachOtherEvent(event.getEntity(), (LivingEntity) event.getSource().getEntity(), LevelInfo.INSTANCE));
            }
        }

        if(event.getEntity().getType().equals(EntityType.ENDER_DRAGON)){

            if(!data.getData().contains("enderdragonkilled")){
                data.getData().putInt("enderdragonkilled", 1);
                LevelInfo.countKillEnderDragon = 1;
            }
            else {
                data.getData().putInt("enderdragonkilled", data.getData().getInt("enderdragonkilled")+1);
                LevelInfo.countKillEnderDragon++;
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDamage(LivingDamageEvent event){
        if(event.getEntity().level().isClientSide) return;
        ServerLevel level = event.getEntity().level().getServer().overworld();
        SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();

        if(event.getSource().getEntity() != null) {
            if (event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
                HistoryList.putItemHistory((Player) event.getSource().getEntity(), event.getEntity(), ((LivingEntity) event.getSource().getEntity()).getMainHandItem());

                if(event.getSource().getEntity() instanceof Player player){
                    if(!HistoryList.COUNT_USE_TOTEM_ON_BATTLE.isEmpty()){
                        for (TotemUseData totemUseData : HistoryList.COUNT_USE_TOTEM_ON_BATTLE) {
                            if(totemUseData.player.equals(player.getUUID())) {
                                totemUseData.coolDown = new Date(System.currentTimeMillis() + 60000);
                                break;
                            }
                        }
                    }
                }

                if(!event.getSource().getEntity().getPersistentData().contains("speedKill")){
                    event.getSource().getEntity().getPersistentData().putInt("speedKill", 1);
                }
            }

            if(event.getEntity() instanceof Player player){
                if(!HistoryList.COUNT_USE_TOTEM_ON_BATTLE.isEmpty()){
                    for (TotemUseData totemUseData : HistoryList.COUNT_USE_TOTEM_ON_BATTLE) {
                        if(totemUseData.player.equals(player.getUUID())) {
                            totemUseData.coolDown = new Date(System.currentTimeMillis() + 60000);
                            break;
                        }
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event){
        if(event.getEntity().level().isClientSide) return;

        if(event.getEntity().getPersistentData().contains("speedKill")){
            event.getEntity().getPersistentData().putInt("speedKill", event.getEntity().getPersistentData().getInt("speedKill") + 1);
        }

        Registry<Structure> str = event.getEntity().level().registryAccess().registryOrThrow(Registries.STRUCTURE);
        for(Structure structure : str){
            if(EntityUtils.onStructure(event.getEntity(), str.getKey(structure))){
                if(!event.getEntity().getPersistentData().contains(str.getKey(structure).getPath())){
                    event.getEntity().getPersistentData().putInt(str.getKey(structure).getPath(), 1);
                } else {
                    event.getEntity().getPersistentData().putInt(str.getKey(structure).getPath(), event.getEntity().getPersistentData().getInt(str.getKey(structure).getPath()));
                }
            }
        }
    }
    @SubscribeEvent
    public static void onLivingUseTotemEvent(LivingUseTotemEvent event){
        if(event.getEntity().level().isClientSide) return;

        if(event.getEntity() instanceof Player player){
            HistoryList.putTotemHistory(player,1);
        }
    }
}
