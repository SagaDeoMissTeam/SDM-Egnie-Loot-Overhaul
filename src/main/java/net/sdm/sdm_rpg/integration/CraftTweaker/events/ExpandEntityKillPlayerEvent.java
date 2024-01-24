package net.sdm.sdm_rpg.integration.CraftTweaker.events;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.events.lootOverhaul.EntityKillPlayerEvent;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/events/living/EntityKillPlayerEvent")
@NativeTypeRegistration(value = EntityKillPlayerEvent.class,zenCodeName = "mods.lootoverhaul.events.living.EntityKillPlayerEvent")
public class ExpandEntityKillPlayerEvent {

    @ZenCodeType.Method
    public static Player getPlayer(EntityKillPlayerEvent event){
        return event.killed;
    }
}
