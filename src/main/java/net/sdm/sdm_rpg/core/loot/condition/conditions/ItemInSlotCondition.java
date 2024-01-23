package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.ItemInSlot")
public class ItemInSlotCondition extends LootCondition {

    public ItemStack stack;
    public int slot;
    public ItemInSlotCondition(){}
    @ZenCodeType.Constructor
    public ItemInSlotCondition(ItemStack stack, int slot, ConditionSide side, LootProperty property){
        super(property,ConditionSide.PLAYER);
        this.stack = stack;
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.ItemInSlot;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
           return player.getInventory().getItem(slot).equals(stack);
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeItem(nbt, "item", stack);
        nbt.putInt("slot", slot);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        stack = NBTUtils.readItem(nbt, "item");
        slot = nbt.getInt("slot");
    }
}
