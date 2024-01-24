package net.sdm.sdm_rpg.core.events.lootOverhaul;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;


public class EntityKillPlayerEvent extends LivingEvent {
    public Player killed;
    public EntityKillPlayerEvent(LivingEntity entity, Player killed) {
        super(entity);
        this.killed = killed;
    }
}
