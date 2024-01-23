package net.sdm.sdm_rpg.core.events.lootOverhaul;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.sdm.sdm_rpg.core.data.LevelInfo;

public class ExplodeCreeperEvent extends LivingEvent {
    public LevelInfo info;
    public int explosionRadius;
    public Creeper creeper;
    public ExplodeCreeperEvent(Creeper entity, int explosionRadius, LevelInfo info) {
        super(entity);
        this.creeper = entity;
        this.explosionRadius = explosionRadius;
        this.info = info;
    }
}
