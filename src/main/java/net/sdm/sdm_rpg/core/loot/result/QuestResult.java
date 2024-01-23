package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.nbt.CompoundTag;

@Deprecated
public class QuestResult extends ILootResult {
    @Override
    public CompoundTag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
