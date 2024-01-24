package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityInFireCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityInFireCondition")
public class EntityInFireCondition extends LootCondition {

    public EntityInFireCondition(){}

    @ZenCodeType.Constructor
    public EntityInFireCondition(ConditionSide side, LootProperty property){
        super(property, side);
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return livingEntity.isOnFire();
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            return player.isOnFire();
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityInFire;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
    }
}
