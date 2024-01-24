package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/IntProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.IntProperty")
public class IntProperty implements INumProperty{

    public int num;

    @ZenCodeType.Constructor
    public IntProperty(int num){
        this.num = num;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("num", num);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        num = nbt.getInt("num");
    }
}
