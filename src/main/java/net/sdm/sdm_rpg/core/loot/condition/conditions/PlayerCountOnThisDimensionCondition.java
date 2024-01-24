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
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/PlayerCountOnThisDimensionCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.PlayerCountOnThisDimensionCondition")
public class PlayerCountOnThisDimensionCondition extends LootCondition {

    public ResourceLocation dimension;

    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;
    public PlayerCountOnThisDimensionCondition(){

    }

    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,int num, LootProperty property){
        this(dimension,new IntProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,int min, int max, LootProperty property){
        this(dimension,new IntRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,double num, LootProperty property){
        this(dimension,new DoubleProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,double min, double max, LootProperty property){
        this(dimension,new DoubleRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,float num, LootProperty property){
        this(dimension,new FloatProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension,float min, float max, LootProperty property){
        this(dimension,new FloatRangeProperty(min,max), property);
    }

    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension, INumProperty pr, LootProperty property){
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
        this.dimension = dimension;
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountOnThisDimension;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        int i = 0;
        if(entity instanceof ServerPlayer player){
            Registry<Level> d1 = entity.level().registryAccess().registryOrThrow(Registries.DIMENSION);
            for(ServerPlayer d2 : player.level().getServer().getPlayerList().getPlayers()){
                if(d2.level() == d1.get(dimension)) i++;
            }

            if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return i == max;
            }
            if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return i >= min || i <= max;
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("dimension", dimension.toString());
        if(min != Integer.MAX_VALUE) nbt.putInt("min", min);
        if(max != Integer.MAX_VALUE) nbt.putInt("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        dimension = new ResourceLocation(nbt.getString("dimension"));
        if(nbt.contains("min")) min = nbt.getInt("min");
        if(nbt.contains("max")) max = nbt.getInt("max");
    }
}
