package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Date;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/RealDateCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.RealDateCondition")
public class RealDateCondition extends LootCondition {

    private Date date;
    public RealDateCondition(){}
    @ZenCodeType.Constructor
    public RealDateCondition(Date date, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.date = date;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.RealDate;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return new Date().equals(date);
    }


    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putLong("date", date.getTime());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        date = new Date(nbt.getLong("date"));
    }
}
