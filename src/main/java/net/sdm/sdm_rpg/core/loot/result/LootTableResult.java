package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;

public class LootTableResult extends ILootResult{
    public ResourceLocation lootTable;

    public LootTableResult(){}

    public LootTableResult(ResourceLocation lootTable){
        this.lootTable = lootTable;
    }

    @Override
    public LootResultList getType() {
        return LootResultList.LootTable;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        lootTable = NBTUtils.readResourceLocation(nbt, "lootTable");

    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeResourceLocation(nbt, "lootTable", lootTable);
        return nbt;
    }
}
