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
@Document("mods/lootoverhaul/loot/condition/type/LootFishingType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootFishingType")
public class LootFishingType extends LootType {

    public List<ResourceLocation> resourceLocations = new ArrayList<>();
    public LootFishingType(){}
    @ZenCodeType.Constructor
    public LootFishingType(ResourceLocation resourceLocation){
        this.resourceLocations.add(resourceLocation);
    }
    @ZenCodeType.Constructor
    public LootFishingType(List<ResourceLocation> resourceLocations){
        this.resourceLocations = resourceLocations;
    }

    @Override
    public LootTypeList getType() {
        return LootTypeList.FISHING;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag lootTables = new ListTag();
        for (ResourceLocation resourceLocation : resourceLocations) {
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
            resourceLocations.add(new ResourceLocation(loot.getString("loot")));
        }
    }
}
