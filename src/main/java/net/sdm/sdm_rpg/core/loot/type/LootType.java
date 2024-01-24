package net.sdm.sdm_rpg.core.loot.type;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/type/LootType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootType")
public class LootType implements INBTSerializable<CompoundTag> {


    @ZenCodeType.Method
    public LootTypeList getType(){
        return null;
    }
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("type", getType().name());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
