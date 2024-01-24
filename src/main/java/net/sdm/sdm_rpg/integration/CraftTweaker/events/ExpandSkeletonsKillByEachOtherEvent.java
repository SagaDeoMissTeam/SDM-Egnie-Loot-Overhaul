package net.sdm.sdm_rpg.integration.CraftTweaker.events;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.minecraft.world.entity.LivingEntity;
import net.sdm.sdm_rpg.core.events.lootOverhaul.SkeletonsKillByEachOtherEvent;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/events/living/SkeletonsKillByEachOtherEvent")
@NativeTypeRegistration(value = SkeletonsKillByEachOtherEvent.class,zenCodeName = "mods.lootoverhaul.events.living.SkeletonsKillByEachOtherEvent")
public class ExpandSkeletonsKillByEachOtherEvent {
    @ZenCodeType.Method
    public static LivingEntity getKiller(SkeletonsKillByEachOtherEvent event){
        return event.killer;
    }

    @ZenCodeType.Method
    public static LivingEntity getDead(SkeletonsKillByEachOtherEvent event){
        return event.getEntity();
    }
}
