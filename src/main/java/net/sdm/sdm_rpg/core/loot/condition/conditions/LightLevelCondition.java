package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.LightLevelCondition")
public class LightLevelCondition extends LootCondition {
    public int lightLevel;
    public LightLevelCondition(){}
    @ZenCodeType.Constructor
    public LightLevelCondition(int lightLevel, ConditionSide side, LootProperty property){
        super(property, side);
        this.lightLevel = lightLevel;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.LightLevel;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return livingEntity.level().getLightEmission(livingEntity.blockPosition()) == lightLevel;
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
            return livingEntity.level().getLightEmission(livingEntity.blockPosition()) == lightLevel;
        }

        return super.isConditionSuccess(entity);
    }


    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("lightLevel", lightLevel);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        lightLevel = nbt.getInt("lightLevel");
    }
}
