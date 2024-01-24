package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/DoubleRangeProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.DoubleRangeProperty")
public class DoubleRangeProperty implements IDoubleNumProperty{
    public double min;
    public double max;

    @ZenCodeType.Constructor
    public DoubleRangeProperty(double min, double max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("min", min);
        nbt.putDouble("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getDouble("min");
        max = nbt.getDouble("max");
    }
}
