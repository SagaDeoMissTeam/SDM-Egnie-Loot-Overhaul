package net.sdm.sdm_rpg.core.loot.type;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/type/LootChestType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootChestType")
public class LootChestType extends LootType{

    public List<ResourceLocation> lootTableID = new ArrayList<>();

    public LootChestType(){}
    @ZenCodeType.Constructor
    public LootChestType(ResourceLocation lootTableID){
        this.lootTableID.add(lootTableID);
    }
    @ZenCodeType.Constructor
    public LootChestType(List<ResourceLocation> lootTableID){
        this.lootTableID = lootTableID;
    }

    @Override
    public LootTypeList getType() {
        return LootTypeList.CHEST;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =super.serializeNBT();
        ListTag lootTables = new ListTag();
        for (ResourceLocation resourceLocation : lootTableID) {
            CompoundTag table = new CompoundTag();
            table.putString("table", resourceLocation.getNamespace() + ":" + resourceLocation.getPath());
            lootTables.add(table);
        }
        nbt.put("lootTables", lootTables);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ListTag lootTables = nbt.getList("lootTables", Tag.TAG_COMPOUND);
        for(int i =0; i < lootTables.size(); i++){
            lootTableID.add(new ResourceLocation(lootTables.getCompound(i).getString("table")));
        }
        super.deserializeNBT(nbt);
    }
}
