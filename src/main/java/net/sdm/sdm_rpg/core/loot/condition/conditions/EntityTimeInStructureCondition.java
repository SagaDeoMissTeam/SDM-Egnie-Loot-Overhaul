package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityTimeInStructureCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityTimeInStructureCondition")
public class EntityTimeInStructureCondition extends LootCondition {

    public ResourceLocation structure;
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;

    public EntityTimeInStructureCondition(){}

    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(int num, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new IntProperty(num), structure,side, property);
    }
    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(int min, int max, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new IntRangeProperty(min,max), structure,side, property);
    }
    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(double num, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new DoubleProperty(num), structure,side, property);
    }
    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(double min, double max, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new DoubleRangeProperty(min,max), structure,side, property);
    }
    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(float num, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new FloatProperty(num), structure,side, property);
    }
    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(float min, float max, ResourceLocation structure,ConditionSide side, LootProperty property){
        this(new FloatRangeProperty(min,max), structure,side, property);
    }

    @ZenCodeType.Constructor
    public EntityTimeInStructureCondition(INumProperty pr, ResourceLocation structure,ConditionSide side, LootProperty property){
        super(property, ConditionSide.PLAYER);
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
        this.structure = structure;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityTimeInStructure;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            if(player.getPersistentData().contains(structure.getPath())){
                if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                    return player.getPersistentData().getInt(structure.getPath()) == max;
                }
                if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                    return player.getPersistentData().getInt(structure.getPath()) >= min || player.getPersistentData().getInt(structure.getPath()) <= max;
                }
            }
        }
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            if(livingEntity.getPersistentData().contains(structure.getPath())){
                if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                    return livingEntity.getPersistentData().getInt(structure.getPath()) == max;
                }
                if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                    return livingEntity.getPersistentData().getInt(structure.getPath()) >= min || livingEntity.getPersistentData().getInt(structure.getPath()) <= max;
                }
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        structure = new ResourceLocation(nbt.getString("structure"));
        if(nbt.contains("min")) min = nbt.getInt("min");
        if(nbt.contains("max")) max = nbt.getInt("max");
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("structure", structure.getNamespace() + ":" + structure.getPath());
        if(min != Integer.MAX_VALUE) nbt.putInt("min", min);
        if(max != Integer.MAX_VALUE) nbt.putInt("max", max);
        return nbt;
    }
}
