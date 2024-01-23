package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.data.HistoryList;
import net.sdm.sdm_rpg.core.data.data.ItemUseData;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerCountUseItemOnBattleCondition")
public class PlayerCountUseItemOnBattleCondition extends LootCondition {
    public List<ItemStack> itemStackList = new ArrayList<>();
    public int count = Integer.MAX_VALUE;
    public PlayerCountUseItemOnBattleCondition(){}
    public PlayerCountUseItemOnBattleCondition(int count, LootProperty property){
        super(property,ConditionSide.PLAYER);
        this.count = count;
    }
    public PlayerCountUseItemOnBattleCondition(List<ItemStack> itemStackList, LootProperty property){
        super(property,ConditionSide.PLAYER);
        this.itemStackList = itemStackList;
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountUseItemOnBattle;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            for (ItemUseData itemUseData : HistoryList.HISTORY_ITEMS_USE) {
                if(itemUseData.player.equals(player.getUUID())){
                    return !itemStackList.isEmpty() ? itemUseData.items.equals(itemStackList) : itemUseData.items.size() == count;
                }
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        if (count != Integer.MAX_VALUE) {
            nbt.putInt("count", count);
        }
        ListTag itemList = new ListTag();
        for(int i =0; i < itemStackList.size(); i++){
            CompoundTag item = new CompoundTag();
            NBTUtils.writeItem(item, "item_" + i, itemStackList.get(i));
            itemList.add(item);
        }
        nbt.put("itemList", itemList);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag itemList = nbt.getList("itemList", Tag.TAG_COMPOUND);
        if(nbt.contains("count")) count = nbt.getInt("count");
        for(int i = 0; i < itemList.size(); i++){
            CompoundTag item = itemList.getCompound(i);
            itemStackList.add(NBTUtils.readItem(item, "item_" + i));
        }
    }
}
