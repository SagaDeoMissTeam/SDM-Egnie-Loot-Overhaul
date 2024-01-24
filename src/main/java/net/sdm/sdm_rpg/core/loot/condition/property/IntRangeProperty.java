package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/IntRangeProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.IntRangeProperty")
public class IntRangeProperty implements INumProperty{

    public int min;
    public int max;

    @ZenCodeType.Constructor
    public IntRangeProperty(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("min", min);
        nbt.putInt("max", max);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        min = nbt.getInt("min");
        max = nbt.getInt("max");
    }
}
