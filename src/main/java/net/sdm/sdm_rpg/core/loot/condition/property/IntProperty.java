package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class IntProperty implements INumProperty{

    public int num;

    public IntProperty(int num){
        this.num = num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        num = nbt.getInt("num");
    }
}
