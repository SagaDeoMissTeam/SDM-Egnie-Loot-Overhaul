package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.INBTSerializable;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootResult;

public class ILootResult implements INBTSerializable<CompoundTag> {

    public ILootResult(){}

    public LootResultList getType(){
        return null;
    }

    public void giveReward(Entity entity, BlockPos pos){

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
