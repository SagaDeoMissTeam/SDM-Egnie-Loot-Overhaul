package net.sdm.sdm_rpg.core.loot.type;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/type/LootTableType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootTableType")
public class LootTableType extends LootType{

    public List<ResourceLocation> lootTable = new ArrayList<>();

    public LootTableType(){}

    @ZenCodeType.Constructor
    public LootTableType(ResourceLocation lootTable){
        this.lootTable.add(lootTable);
    }
    @ZenCodeType.Constructor
    public LootTableType(List<ResourceLocation> lootTable){
        this.lootTable = lootTable;
    }

    @Override
    public LootTypeList getType() {
        return LootTypeList.TABLE;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag lootTables = new ListTag();
        for (ResourceLocation resourceLocation : lootTable) {
            CompoundTag tag = new CompoundTag();
            tag.putString("loot", resourceLocation.getNamespace() + ":" + resourceLocation.getPath());
            lootTables.add(tag);
        }
        nbt.put("lootlist", lootTables);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag lootTables = nbt.getList("lootlist", Tag.TAG_COMPOUND);
        for(int i = 0; i < lootTables.size(); i++){
            CompoundTag loot = lootTables.getCompound(i);
            lootTable.add(new ResourceLocation(loot.getString("loot")));
        }
    }
}
