package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootResult;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/ILootResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.ILootResult")
public class ILootResult implements INBTSerializable<CompoundTag> {

    @ZenCodeType.Constructor
    public ILootResult(){}

    @ZenCodeType.Method
    public LootResultList getType(){
        return null;
    }

    @ZenCodeType.Method
    public boolean giveReward(Entity entity, BlockPos pos){
        return false;
    }

    public boolean addToContainer(Container container){
        return false;
    }

    public boolean addToList(List<ItemStack> list){
        return false;
    }

    public boolean createOnWorld(Level level, BlockPos pos){
        return false;
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
