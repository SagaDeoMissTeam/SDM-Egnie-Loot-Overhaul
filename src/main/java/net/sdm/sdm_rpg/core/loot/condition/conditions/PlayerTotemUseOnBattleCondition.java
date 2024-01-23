package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.data.HistoryList;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.data.data.TotemUseData;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.property.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerTotemUseOnBattleCondition")
public class PlayerTotemUseOnBattleCondition extends LootCondition {

    public int max = Integer.MAX_VALUE;
    public int min = Integer.MAX_VALUE;

    public PlayerTotemUseOnBattleCondition(){

    }

    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(int num, LootProperty property){
        this(new IntProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(int min, int max, LootProperty property){
        this(new IntRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(double num, LootProperty property){
        this(new DoubleProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(double min, double max, LootProperty property){
        this(new DoubleRangeProperty(min,max), property);
    }
    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(float num, LootProperty property){
        this(new FloatProperty(num), property);
    }
    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(float min, float max, LootProperty property){
        this(new FloatRangeProperty(min,max), property);
    }

    @ZenCodeType.Constructor
    public PlayerTotemUseOnBattleCondition(INumProperty pr, LootProperty property){
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
        if(entity instanceof Player player){
            for (TotemUseData totemUseData : HistoryList.COUNT_USE_TOTEM_ON_BATTLE) {
                if(totemUseData.player.equals(player.getUUID())){
                    if(min == Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                        return totemUseData.count >= max;
                    }
                    if(min != Integer.MAX_VALUE && max != Integer.MAX_VALUE){
                        return totemUseData.count >= min || totemUseData.count <= max;
                    }
                }
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
        return ConditionsList.PlayerTotemUseOnBattle;
    }
}
