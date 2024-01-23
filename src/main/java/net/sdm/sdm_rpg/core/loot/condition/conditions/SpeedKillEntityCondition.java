package net.sdm.sdm_rpg.core.loot.condition.conditions;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

// Убийство моба на скорость
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.SpeedKillEntityCondition")
public class SpeedKillEntityCondition extends LootCondition {
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;

    public SpeedKillEntityCondition(){

    }

    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(int num, LootProperty property){
        this(new IntProperty(num), property);
    }
    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(int min, int max, LootProperty property){
        this(new IntRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(double num, LootProperty property){
        this(new DoubleProperty(num), property);
    }
    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(double min, double max, LootProperty property){
        this(new DoubleRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(float num, LootProperty property){
        this(new FloatProperty(num), property);
    }
    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(float min, float max, LootProperty property){
        this(new FloatRangeProperty(min,max), property);
    }

    @ZenCodeType.Constructor
    public SpeedKillEntityCondition(INumProperty pr, LootProperty property){
        super(property, ConditionSide.ENTITY);
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
    public boolean isConditionSuccess(Entity entity) {
        if(entity.getPersistentData().contains("speedKill")) {
            if (min == Integer.MAX_VALUE && max != Integer.MAX_VALUE) {
                return entity.getPersistentData().getInt("speedKill") <= max;
            }
            if (min != Integer.MAX_VALUE && max != Integer.MAX_VALUE) {
                return entity.getPersistentData().getInt("speedKill") >= min || entity.getPersistentData().getInt("speedKill") <= max;
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();

        if(min != Integer.MAX_VALUE) tag.putInt("min", min);
        if(max != Integer.MAX_VALUE) tag.putInt("max", max);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(nbt.contains("min")) min = nbt.getInt("min");
        if(nbt.contains("max")) min = nbt.getInt("max");
        super.deserializeNBT(nbt);
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.SpeedKillEntity;
    }
}
