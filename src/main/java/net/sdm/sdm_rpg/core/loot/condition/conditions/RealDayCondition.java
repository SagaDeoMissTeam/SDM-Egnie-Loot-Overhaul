package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Calendar;
import java.util.Date;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.RealDayCondition")
public class RealDayCondition extends LootCondition {

    private int day;
    public RealDayCondition(){}
    @ZenCodeType.Constructor
    public RealDayCondition(int day, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.day = day;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.RealDay;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return new Date().getDay() == day;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("day", day);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        day = nbt.getInt("day");
    }
}
