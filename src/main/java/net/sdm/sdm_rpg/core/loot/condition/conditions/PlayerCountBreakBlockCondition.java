package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/PlayerCountBreakBlockCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.PlayerCountBreakBlockCondition")
public class PlayerCountBreakBlockCondition extends LootCondition {
    public Block block;
    public int count;
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;

    public PlayerCountBreakBlockCondition(){

    }

    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,int num, LootProperty property){
        this(block,new IntProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,int min, int max, LootProperty property){
        this(block,new IntRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,double num, LootProperty property){
        this(block,new DoubleProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,double min, double max, LootProperty property){
        this(block,new DoubleRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,float num, LootProperty property){
        this(block,new FloatProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block,float min, float max, LootProperty property){
        this(block,new FloatRangeProperty(min,max), property);
    }

    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block, INumProperty pr, LootProperty property){
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
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof ServerPlayer player){
            if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return player.getStats().getValue(Stats.BLOCK_MINED.get(block)) == max;
            }
            if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                return player.getStats().getValue(Stats.BLOCK_MINED.get(block)) >= min || player.getStats().getValue(Stats.BLOCK_MINED.get(block)) <= max;
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountBreakBlock;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeResourceLocation(nbt,"block", ForgeRegistries.BLOCKS.getKey(block));
        if(min != Integer.MAX_VALUE) nbt.putInt("min", min);
        if(max != Integer.MAX_VALUE) nbt.putInt("max", max);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(nbt.getString("block")));
        if(nbt.contains("min")) min = nbt.getInt("min");
        if(nbt.contains("max")) max = nbt.getInt("max");
    }
}
