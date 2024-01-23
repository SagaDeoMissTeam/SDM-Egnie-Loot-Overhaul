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
@ZenCodeType.Name("mods.sdmrpg.loot.condition.RandomNumberCondition")
public class RandomNumberCondition extends LootCondition {

    public int min;
    public int max;
    public int num;
    public RandomNumberCondition(){}
    @ZenCodeType.Constructor
    public RandomNumberCondition(int min, int max, int num, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.max= max;
        this.min = min;
        this.num = num;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.RandomNumber;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.level().random.nextInt(min, max) == num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("min", min);
        nbt.putInt("max", max);
        nbt.putInt("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        min = nbt.getInt("min");
        max = nbt.getInt("max");
        num = nbt.getInt("num");
    }
}
