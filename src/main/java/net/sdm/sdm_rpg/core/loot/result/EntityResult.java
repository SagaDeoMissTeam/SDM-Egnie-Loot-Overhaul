package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/CommandResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.CommandResult")
public class EntityResult extends ILootResult{

    public EntityType<?> entityType;
    public CompoundTag nbt;

    public EntityResult(){

    }
    @ZenCodeType.Constructor
    public EntityResult(EntityType<?> entityType){
        this.entityType = entityType;
        this.nbt = new CompoundTag();
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Entity;
    }

    @Override
    public boolean createOnWorld(Level level, BlockPos pos) {
        Entity d1 = entityType.create(level);
        if(d1 != null) {
            level.addFreshEntity(d1);
            d1.teleportTo(pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return super.createOnWorld(level, pos);
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
