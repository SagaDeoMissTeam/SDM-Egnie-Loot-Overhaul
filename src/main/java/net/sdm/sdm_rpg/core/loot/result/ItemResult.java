package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/ItemResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.ItemResult")
public class ItemResult extends ILootResult{

    public ItemStack item;
    public ItemResult(){

    }
    @ZenCodeType.Constructor
    public ItemResult(ItemStack item){
        this.item = item;
    }

    @Override
    public boolean addToContainer(Container container) {
        for(int i = 0; i < container.getContainerSize(); i++){
            if(container.canPlaceItem(i, item)){
                container.setItem(i, item);
                return true;
            }
        }

        return super.addToContainer(container);
    }

    @Override
    public boolean createOnWorld(Level level, BlockPos pos) {
        ItemEntity entity = new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(), item);
        return level.addFreshEntity(entity);
    }

    @Override
    public boolean addToList(List<ItemStack> list) {
        return list.add(item);
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Item;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeItem(nbt, "item", item);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        item = NBTUtils.readItem(nbt, "item");
    }
}
