package net.sdm.sdm_rpg.core.events.lootOverhaul;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

@Deprecated
public class EnderDragonDeadEvent extends LivingEvent {
    public EnderDragonDeadEvent(LivingEntity entity) {
        super(entity);
    }
}
