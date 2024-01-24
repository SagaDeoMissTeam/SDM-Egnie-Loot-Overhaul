package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.loot.table.LootTableManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/LootTableResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.LootTableResult")
public class LootTableResult extends ILootResult{
    public ResourceLocation lootTable;

    public LootTableResult(){}

    @ZenCodeType.Constructor
    public LootTableResult(ResourceLocation lootTable){
        this.lootTable = lootTable;
    }

    @Override
    public LootResultList getType() {
        return LootResultList.LootTable;
    }



    @Override
    public boolean addToContainer(Container container) {
        if (container instanceof Inventory inventory) {

        }
        if (container instanceof RandomizableContainerBlockEntity lootChest && lootChest.getLevel() != null) {
            //lootChest.getLevel().getServer().getLootData().getLootTable(lootTable)
        }
        return super.addToContainer(container);
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        lootTable = NBTUtils.readResourceLocation(nbt, "lootTable");

    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeResourceLocation(nbt, "lootTable", lootTable);
        return nbt;
    }
}
