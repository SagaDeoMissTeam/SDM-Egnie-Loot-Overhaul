package net.sdm.sdm_rpg.core.data.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.Date;
import java.util.UUID;

public class TotemUseData implements ILootData{
    public UUID player;
    public long count;
    public Date coolDown;

    public TotemUseData(Player player, long count){
        this.player = player.getUUID();
        this.count = count;
        this.coolDown = new Date(System.currentTimeMillis() + 10000);
    }

    @Override
    public CompoundTag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
