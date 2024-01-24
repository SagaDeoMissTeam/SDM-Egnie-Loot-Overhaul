package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/PlayerCountOnThisServerCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.PlayerCountOnThisServerCondition")
public class PlayerCountOnThisServerCondition extends LootCondition {

    public int count;
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;
    public boolean isCanBeMore = false;
    public PlayerCountOnThisServerCondition(){

    }

    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(int num, LootProperty property){
        this(new IntProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(int min, int max, LootProperty property){
        this(new IntRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(double num, LootProperty property){
        this(new DoubleProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(double min, double max, LootProperty property){
        this(new DoubleRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(float num, LootProperty property){
        this(new FloatProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(float min, float max, LootProperty property){
        this(new FloatRangeProperty(min,max), property);
    }

    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(INumProperty pr, LootProperty property){
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
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountOnThisServer;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
            return entity.level().getServer().getPlayerList().getPlayers().size() == max;
        }
        if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
            return entity.level().getServer().getPlayerList().getPlayers().size() >= min || entity.level().getServer().getPlayerList().getPlayers().size() <= max;
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
