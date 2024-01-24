package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/IFloatNumProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.IFloatNumProperty")
public interface IFloatNumProperty extends INumProperty{
}
