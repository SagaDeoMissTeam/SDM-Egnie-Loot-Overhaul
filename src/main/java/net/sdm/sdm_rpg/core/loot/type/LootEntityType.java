package net.sdm.sdm_rpg.core.loot.type;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/type/LootChestType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootChestType")
public class LootEntityType extends LootType {
    public List<EntityType<?>> entityTypeList = new ArrayList<>();

    public LootEntityType(){}
    @ZenCodeType.Constructor
    public LootEntityType(EntityType<?> entityTypeList){
        this.entityTypeList.add(entityTypeList);
    }
    @ZenCodeType.Constructor
    public LootEntityType(List<EntityType<?>> entityTypeList){
        this.entityTypeList = entityTypeList;
    }

    @Override
    public LootTypeList getType() {
        return LootTypeList.ENTITY;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag entityList = new ListTag();
        for(EntityType<?> entityType : entityTypeList){
            CompoundTag enity = new CompoundTag();
            enity.putString("entity", ForgeRegistries.ENTITY_TYPES.getKey(entityType).getNamespace() + ":" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
            entityList.add(enity);
        }
        nbt.put("entities", entityList);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag entityList = nbt.getList("entities", Tag.TAG_COMPOUND);
        for(int i = 0; i < entityList.size(); i++){
            CompoundTag enity = entityList.getCompound(i);
            entityTypeList.add(ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(enity.getString("entity"))));
        }
    }
}
