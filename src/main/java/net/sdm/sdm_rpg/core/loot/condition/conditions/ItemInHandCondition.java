package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
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
@Document("mods/lootoverhaul/loot/condition/ItemInHandCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.ItemInHandCondition")
public class ItemInHandCondition extends LootCondition {

    public ItemStack stack;
    public InteractionHand hand;
    public ItemInHandCondition(){}
    @ZenCodeType.Constructor
    public ItemInHandCondition(ItemStack stack, InteractionHand hand, ConditionSide side, LootProperty property){
        super(property,side);
        this.stack = stack;
        this.hand = hand;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.ItemInHand;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return livingEntity.getItemInHand(hand).equals(stack);
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            return player.getItemInHand(hand).equals(stack);
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeItem(nbt, "item", stack);
        nbt.putString("hand", hand.name());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        stack = NBTUtils.readItem(nbt, "item");
        hand = InteractionHand.valueOf(nbt.getString("hand"));
    }
}
