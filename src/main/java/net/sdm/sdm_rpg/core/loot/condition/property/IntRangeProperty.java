package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class IntRangeProperty implements INumProperty{

    public int min;
    public int max;

    public IntRangeProperty(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("min", min);
        nbt.putInt("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getInt("min");
        max = nbt.getInt("max");
    }
}
