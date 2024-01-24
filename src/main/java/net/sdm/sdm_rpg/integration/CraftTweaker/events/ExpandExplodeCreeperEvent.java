package net.sdm.sdm_rpg.integration.CraftTweaker.events;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.sdm.sdm_rpg.core.events.lootOverhaul.ExplodeCreeperEvent;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/events/living/ExplodeCreeperEvent")
@NativeTypeRegistration(value = ExplodeCreeperEvent.class,zenCodeName = "mods.lootoverhaul.events.living.ExplodeCreeperEvent")
public class ExpandExplodeCreeperEvent {

    @ZenCodeType.Method
    public static int getExplosionRadius(ExplodeCreeperEvent event){
        return event.explosionRadius;
    }
}
