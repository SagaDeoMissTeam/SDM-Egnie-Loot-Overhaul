package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;

public class StringProperty implements IProperty{

    public String field;

    public StringProperty(String field){
        this.field = field;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("field", field);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        field = nbt.getString("field");
    }
}
