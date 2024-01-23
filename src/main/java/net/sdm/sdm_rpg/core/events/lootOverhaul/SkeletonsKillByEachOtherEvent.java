package net.sdm.sdm_rpg.core.events.lootOverhaul;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.sdm.sdm_rpg.core.data.LevelInfo;

public class SkeletonsKillByEachOtherEvent extends LivingEvent {

    public LevelInfo info;
    public LivingEntity killer;
    public SkeletonsKillByEachOtherEvent(LivingEntity entity, LivingEntity killer, LevelInfo info) {
        super(entity);
        this.killer = killer;
        this.info = info;
    }
}
