package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.GameDayCondition")
public class GameDayCondition extends LootCondition {

    public long day;
    public GameDayCondition(){}
    @ZenCodeType.Constructor
    public GameDayCondition(long day, LootProperty property){
        super(property,ConditionSide.ENTITY);
        this.day = day;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.GameDay;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.level().getGameTime() % 24000 >= day;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putLong("day", day);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        day = nbt.getLong("day");
    }
}
