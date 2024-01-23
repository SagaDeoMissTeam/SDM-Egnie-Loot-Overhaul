package net.sdm.sdm_rpg.core.data.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

    public class TimeInStructureData implements ILootData {

    @Nullable
    public UUID player;
    @Nullable
    public UUID entity;
    public ResourceLocation structure;
    public long timeEnd;
    public long timeStart;

    public TimeInStructureData(){}
    public TimeInStructureData(@Nullable Player player,@Nullable Entity entity, ResourceLocation structure, long timeEnd){
        if(player != null)
            this.player = player.getUUID();
        if(entity != null)
            this.entity = entity.getUUID();
        this.structure = structure;
        this.timeStart = 0;
        this.timeEnd = timeEnd;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        if(player != null)
            nbt.putUUID("player", player);
        if(entity != null)
            nbt.putUUID("entity", entity);
        nbt.putString("structure", structure.getNamespace() + ":" + structure.getPath());
        nbt.putLong("timeStart", timeStart);
        nbt.putLong("timeEnd", timeEnd);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(nbt.contains("player")) player = nbt.getUUID("player");
        if(nbt.contains("entity")) entity = nbt.getUUID("entity");
        structure = new ResourceLocation(nbt.getString("structure"));
        timeStart = nbt.getLong("timeStart");
        timeEnd = nbt.getLong("timeEnd");

    }
}
