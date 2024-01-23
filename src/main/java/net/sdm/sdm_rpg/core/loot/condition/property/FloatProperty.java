package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class FloatProperty implements IFloatNumProperty{

    public float num;

    public FloatProperty(float num){
        this.num = num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =new CompoundTag();
        nbt.putFloat("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        num = nbt.getFloat("num");
    }
}
