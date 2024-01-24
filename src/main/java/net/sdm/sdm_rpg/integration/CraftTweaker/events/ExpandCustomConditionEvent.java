package net.sdm.sdm_rpg.integration.CraftTweaker.events;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.sdm.sdm_rpg.core.events.lootOverhaul.CustomConditionEvent;
import net.sdm.sdm_rpg.core.loot.type.LootType;
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/events/living/CustomConditionEvent")
@NativeTypeRegistration(value = CustomConditionEvent.class,zenCodeName = "mods.lootoverhaul.events.living.CustomConditionEvent")
public class ExpandCustomConditionEvent {

    @ZenCodeType.Method
    public static void setResult(CustomConditionEvent event, boolean result) {
        event.setResult(result);
    }
    @ZenCodeType.Method
    @ZenCodeType.Getter("pos")
    public static @Nullable BlockPos getPos(CustomConditionEvent event) {
        return event.getPos();
    }
    @ZenCodeType.Method
    @ZenCodeType.Getter("id")
    public static String getId(CustomConditionEvent event) {
        return event.getId();
    }
    @ZenCodeType.Method
    @ZenCodeType.Getter("level")
    public static @Nullable Level getLevel(CustomConditionEvent event) {
        return event.getLevel();
    }
    @ZenCodeType.Method
    @ZenCodeType.Getter("blockEntity")
    public static @Nullable BlockEntity getBlockEntity(CustomConditionEvent event) {
        return event.getBlockEntity();
    }
    @ZenCodeType.Method
    @ZenCodeType.Getter("entity")
    public static @Nullable Entity getEntity(CustomConditionEvent event) {
        return event.getEntity();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("entityKilled")
    public static @Nullable Entity getEntityKilled(CustomConditionEvent event) {
        return event.getEntityKilled();
    }

    @ZenCodeType.Method
    public static LootType getType(CustomConditionEvent event) {
        return event.getType();
    }
}
