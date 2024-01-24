package net.sdm.sdm_rpg.core.events.lootOverhaul;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.eventbus.api.Event;
import net.sdm.sdm_rpg.core.loot.type.LootType;
import org.jetbrains.annotations.Nullable;

public class CustomConditionEvent extends Event {

    public boolean result = false;
    public String id;
    public @Nullable Entity entity;
    public @Nullable Entity entityKilled;
    public @Nullable BlockPos pos;
    public @Nullable Level level;
    public @Nullable BlockEntity blockEntity;
    public LootType type;
    public CustomConditionEvent(String id, @Nullable Entity entity, @Nullable Entity entityKilled, @Nullable BlockPos pos, @Nullable Level level, @Nullable BlockEntity blockEntity, LootType type) {
        this.id = id;
        this.entity = entity;
        this.entityKilled = entityKilled;
        this.pos = pos;
        this.level = level;
        this.blockEntity = blockEntity;
        this.type = type;
    }


    public void setResult(boolean result) {
        this.result = result;
    }

    public @Nullable BlockPos getPos() {
        return pos;
    }

    public String getId() {
        return id;
    }

    public @Nullable Level getLevel() {
        return level;
    }

    public @Nullable BlockEntity getBlockEntity() {
        return blockEntity;
    }

    public @Nullable Entity getEntity() {
        return entity;
    }

    public @Nullable Entity getEntityKilled() {
        return entityKilled;
    }

    public LootType getType() {
        return type;
    }
}
