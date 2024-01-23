package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.ItemInInventory")
public class ItemInInventoryCondition extends LootCondition {

    public ItemStack stack;
    public ItemInInventoryCondition(){}
    @ZenCodeType.Constructor
    public ItemInInventoryCondition(ItemStack stack, ConditionSide side, LootProperty property){
        super(property,side);
        this.stack = stack;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.ItemInInventory;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            for(ItemStack d1 : livingEntity.getArmorSlots()){
                return d1.equals(stack);
            }
            if(livingEntity.getItemInHand(InteractionHand.MAIN_HAND).equals(stack)) return true;
            if(livingEntity.getItemInHand(InteractionHand.OFF_HAND).equals(stack)) return true;
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            return player.getInventory().contains(stack);
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeItem(nbt, "item", stack);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        stack = NBTUtils.readItem(nbt, "item");
    }
}
