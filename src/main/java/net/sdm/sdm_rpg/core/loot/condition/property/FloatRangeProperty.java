package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/FloatRangeProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.FloatRangeProperty")
public class FloatRangeProperty implements IFloatNumProperty{
    public float min;
    public float max;

    @ZenCodeType.Constructor
    public FloatRangeProperty(float min, float max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("min", min);
        nbt.putFloat("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getFloat("min");
        max = nbt.getFloat("max");
    }
}
