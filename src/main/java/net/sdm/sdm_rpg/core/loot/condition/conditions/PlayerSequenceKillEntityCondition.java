package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.EntitySequenceKilledCondition")
public class PlayerSequenceKillEntityCondition extends LootCondition {

    public List<EntityType<?>> entity = new ArrayList<>();
    public List<ItemStack> itemStackList = new ArrayList<>();
    public PlayerSequenceKillEntityCondition(){}

    public PlayerSequenceKillEntityCondition(EntityType<?> entityType, List<ItemStack> itemStackList, LootProperty property){
        super(property,ConditionSide.PLAYER);
        this.entity.add(entityType);
        this.itemStackList = itemStackList;
    }
    public PlayerSequenceKillEntityCondition(List<EntityType<?>> entityType, List<ItemStack> itemStackList, LootProperty property){
        super(property,ConditionSide.PLAYER);
        this.entity.addAll(entityType);
        this.itemStackList = itemStackList;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerSequenceKillEntity;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
//        if(side == ConditionSide.PLAYER && entity instanceof Player player){
//            for (ItemUseData itemUseData : HistoryList.HISTORY_ITEMS_USE) {
//                if(itemUseData.player.equals(player.getUUID())){
//                   return itemUseData.items.equals(itemStackList);
//                }
//            }
//        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag itemList = new ListTag();
        for(int i =0; i < itemStackList.size(); i++){
            CompoundTag item = new CompoundTag();
            NBTUtils.writeItem(item, "item_" + i, itemStackList.get(i));
            itemList.add(item);
        }
        ListTag entityList = new ListTag();
        for(int i = 0; i < entity.size(); i++){
            CompoundTag ent = new CompoundTag();
            ent.putString("entity_" + i, entity.get(i).getDescriptionId());
            entityList.add(ent);
        }
        nbt.put("itemList", itemList);
        nbt.put("entityList", entityList);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag itemList = nbt.getList("itemList", Tag.TAG_COMPOUND);
        ListTag entityList = nbt.getList("entityList", Tag.TAG_COMPOUND);

        for(int i = 0; i < itemList.size(); i++){
            CompoundTag item = itemList.getCompound(i);
            itemStackList.add(NBTUtils.readItem(item, "item_" + i));
        }
        for(int i = 0; i < entityList.size(); i++){
            CompoundTag ent = entityList.getCompound(i);
            entity.add(ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(ent.getString("entity_" + i))));
        }
    }
}
