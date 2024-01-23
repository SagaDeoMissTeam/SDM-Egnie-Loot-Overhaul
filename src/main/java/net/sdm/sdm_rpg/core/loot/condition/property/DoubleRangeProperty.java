package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class DoubleRangeProperty implements IDoubleNumProperty{
    public double min;
    public double max;

    public DoubleRangeProperty(double min, double max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("min", min);
        nbt.putDouble("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getDouble("min");
        max = nbt.getDouble("max");
    }
}
