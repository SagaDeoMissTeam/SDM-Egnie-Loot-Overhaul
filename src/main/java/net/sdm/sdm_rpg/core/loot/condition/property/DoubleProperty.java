package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/DoubleProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.DoubleProperty")
public class DoubleProperty implements IDoubleNumProperty{
    public double num;
    @ZenCodeType.Constructor
    public DoubleProperty(double num){
        this.num = num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =new CompoundTag();
        nbt.putDouble("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        num = nbt.getDouble("num");
    }
}
