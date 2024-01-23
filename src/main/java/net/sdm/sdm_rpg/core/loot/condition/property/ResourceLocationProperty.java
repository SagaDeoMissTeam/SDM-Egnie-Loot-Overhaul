package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class ResourceLocationProperty implements IProperty{
    public ResourceLocation field;

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
