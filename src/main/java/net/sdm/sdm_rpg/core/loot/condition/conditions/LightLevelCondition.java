package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/LightLevelCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.LightLevelCondition")
public class LightLevelCondition extends LootCondition {
    public int lightLevel;
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;
    public LightLevelCondition(){}

    @ZenCodeType.Constructor
    public LightLevelCondition(int num,ConditionSide side, LootProperty property){
        this(new IntProperty(num),side, property);
    }
    @ZenCodeType.Constructor
    public LightLevelCondition(int min, int max,ConditionSide side, LootProperty property){
        this(new IntRangeProperty(min,max),side, property);
    }
    @ZenCodeType.Constructor
    public LightLevelCondition(double num,ConditionSide side, LootProperty property){
        this(new DoubleProperty(num),side, property);
    }
    @ZenCodeType.Constructor
    public LightLevelCondition(double min, double max,ConditionSide side, LootProperty property){
        this(new DoubleRangeProperty(min,max),side, property);
    }
    @ZenCodeType.Constructor
    public LightLevelCondition(float num,ConditionSide side, LootProperty property){
        this(new FloatProperty(num),side, property);
    }
    @ZenCodeType.Constructor
    public LightLevelCondition(float min, float max,ConditionSide side, LootProperty property){
        this(new FloatRangeProperty(min,max),side, property);
    }

    @ZenCodeType.Constructor
    public LightLevelCondition(INumProperty pr,ConditionSide side, LootProperty property){
        super(property, side);
        if(pr instanceof IntProperty propertyInt){
            max = propertyInt.num;
        }
        else if(pr instanceof IntRangeProperty propertyRange){
            min = propertyRange.min;
            max = propertyRange.max;
        }
        else if(pr instanceof FloatProperty single){
            max = (int) single.num;
        }
        else if(pr instanceof FloatRangeProperty single){
            max = (int) single.max;
            min = (int) single.min;
        }
        else if(pr instanceof DoubleProperty single){
            max = (int) single.num;
        }
        else if(pr instanceof DoubleRangeProperty single){
            max = (int) single.max;
            min = (int) single.min;
        }
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.LightLevel;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return livingEntity.level().getLightEmission(livingEntity.blockPosition()) >= max;
            }
            if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return livingEntity.level().getLightEmission(livingEntity.blockPosition()) >= min || livingEntity.level().getLightEmission(livingEntity.blockPosition()) <= max;
            }
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
            if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return livingEntity.level().getLightEmission(livingEntity.blockPosition()) >= max;
            }
            if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return livingEntity.level().getLightEmission(livingEntity.blockPosition()) >= min || livingEntity.level().getLightEmission(livingEntity.blockPosition()) <= max;
            }
        }

        return super.isConditionSuccess(entity);
    }


    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        if(min != Integer.MAX_VALUE) nbt.putInt("min", min);
        if(max != Integer.MAX_VALUE) nbt.putInt("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        if(nbt.contains("min")) min = nbt.getInt("min");
        if(nbt.contains("max")) max = nbt.getInt("max");


    }
}
