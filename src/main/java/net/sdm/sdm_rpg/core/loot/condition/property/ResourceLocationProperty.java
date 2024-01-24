package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/ResourceLocationProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.ResourceLocationProperty")
public class ResourceLocationProperty implements IProperty{
    public ResourceLocation field;

    @ZenCodeType.Constructor
    public ResourceLocationProperty(ResourceLocation field){
        this.field= field;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("field", field.toString());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        field = new ResourceLocation(nbt.getString("field"));
    }
}
