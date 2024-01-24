package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/FloatProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.FloatProperty")
public class FloatProperty implements IFloatNumProperty{

    public float num;

    @ZenCodeType.Constructor
    public FloatProperty(float num){
        this.num = num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =new CompoundTag();
        nbt.putFloat("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        num = nbt.getFloat("num");
    }
}
