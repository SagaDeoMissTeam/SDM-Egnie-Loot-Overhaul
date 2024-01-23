package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;

public class EntityResult extends ILootResult{

    public EntityType<?> entityType;
    public CompoundTag nbt;

    public EntityResult(){

    }
    public EntityResult(EntityType<?> entityType){
        this.entityType = entityType;
        this.nbt = new CompoundTag();
    }
//    public EntityResult(EntityType<?> entityType, CompoundTag nbt){
//        this.entityType = entityType;
//        this.nbt = nbt;
//    }

    @Override
    public LootResultList getType() {
        return LootResultList.Entity;
    }

    @Override
    public void giveReward(Entity entity, BlockPos pos) {
        Entity d1 = entityType.create(entity.level());
        if(d1 != null) {
            d1.getPersistentData().merge(nbt);
            d1.teleportTo(pos.getX(), pos.getY(), pos.getZ());
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeEntity(nbt, "entity", entityType);
        //if(!nbt.isEmpty()) nbt.put("nbtTag", nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        entityType = NBTUtils.readEntity(nbt,"entity");
        //if(nbt.contains("nbtTag")) this.nbt = nbt.getCompound("nbt");
    }
}
