package net.sdm.sdm_rpg.core.utils.serializer;

import net.minecraft.nbt.Tag;

public interface ISDMSerializer <T extends Tag> {

    T serializeNBT();
    void deserializeNBT(T nbt);
}
