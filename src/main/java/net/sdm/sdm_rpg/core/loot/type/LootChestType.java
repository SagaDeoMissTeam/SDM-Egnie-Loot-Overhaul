package net.sdm.sdm_rpg.core.loot.type;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class LootChestType extends LootType{

    public List<ResourceLocation> lootTableID = new ArrayList<>();

    public LootChestType(){}
    public LootChestType(ResourceLocation lootTableID){
        this.lootTableID.add(lootTableID);
    }
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
