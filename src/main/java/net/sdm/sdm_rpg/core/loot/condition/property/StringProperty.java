package net.sdm.sdm_rpg.core.loot.condition.property;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/property/StringProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.property.StringProperty")
public class StringProperty implements IProperty{

    public String field;

    @ZenCodeType.Constructor
    public StringProperty(String field){
        this.field = field;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("field", field);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        field = nbt.getString("field");
    }
}
