package net.sdm.sdm_rpg.core.loot.type;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class LootType implements INBTSerializable<CompoundTag> {


    public LootTypeList getType(){
        return null;
    }
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("type", getType().name());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
