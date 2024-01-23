package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class FloatRangeProperty implements IFloatNumProperty{
    public float min;
    public float max;

    public FloatRangeProperty(float min, float max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("min", min);
        nbt.putFloat("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getFloat("min");
        max = nbt.getFloat("max");
    }
}
