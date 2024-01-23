package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.nbt.CompoundTag;

@Deprecated
public class AttributeResult extends ILootResult{


    @Override
    public LootResultList getType() {
        return LootResultList.Attribute;
    }

    @Override
    public CompoundTag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
