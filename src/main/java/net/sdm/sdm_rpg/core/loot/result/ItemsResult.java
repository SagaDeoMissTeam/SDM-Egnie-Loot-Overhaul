package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/ItemsResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.ItemsResult")
public class ItemsResult extends ILootResult{
    public List<ItemStack> item;
    public ItemsResult(){

    }
    @ZenCodeType.Constructor
    public ItemsResult(List<ItemStack> item){
        this.item = item;
    }
    @ZenCodeType.Constructor
    public ItemsResult(ItemStack[] item){
        this.item = List.of(item);
    }

    @Override
    public boolean createOnWorld(Level level, BlockPos pos) {
        int spawn = 0;
        for (ItemStack stack : item) {
            ItemEntity entity = new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
            if(level.addFreshEntity(entity)){
                spawn++;
            }
        }
        if(spawn >= item.size() / 2) return true;

        return super.createOnWorld(level, pos);
    }

    @Override
    public boolean addToContainer(Container container) {
        if(item.isEmpty()) return false;
        int count = 0;
        List<Integer> freeSlots = new ArrayList<>();
        for(int i = 0; i < container.getContainerSize(); i++){
            if(container.canPlaceItem(i, item.get(0))) {
                count++;
                freeSlots.add(i);
            }
        }

        if(count != 0){
            for(int i =0; i < item.size(); i++){
                if(i <= freeSlots.size())
                    container.setItem(freeSlots.get(i), item.get(i));
                else {
                    if(container instanceof Inventory inventory){
                       inventory.player.drop(item.get(i), false);
                    }
                    if(container instanceof RandomizableContainerBlockEntity lootChest && lootChest.getLevel() != null){
                        ItemEntity d1 = new ItemEntity(lootChest.getLevel(), lootChest.getBlockPos().getX(), lootChest.getBlockPos().getY() + 1, lootChest.getBlockPos().getZ(), item.get(i));
                        lootChest.getLevel().addFreshEntity(d1);
                    }
                }
            }
        } else {
            for (ItemStack stack : item) {
                if (container instanceof Inventory inventory) {
                    inventory.player.drop(stack, false);
                }
                if (container instanceof RandomizableContainerBlockEntity lootChest && lootChest.getLevel() != null) {
                    ItemEntity d1 = new ItemEntity(lootChest.getLevel(), lootChest.getBlockPos().getX(), lootChest.getBlockPos().getY() + 1, lootChest.getBlockPos().getZ(), stack);
                    lootChest.getLevel().addFreshEntity(d1);
                }
            }
        }


        return super.addToContainer(container);
    }

    @Override
    public boolean addToList(List<ItemStack> list) {
        return list.addAll(item);
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Items;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag items = new ListTag();
        item.forEach(itemStack -> {
            CompoundTag d1 = new CompoundTag();
            NBTUtils.writeItem(d1, "item", itemStack);
            items.add(d1);
        });
        nbt.put("items", items);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag d1 = nbt.getList("items", Tag.TAG_COMPOUND);
        d1.forEach(s -> {
            item.add(NBTUtils.readItem((CompoundTag) s, "item"));
        });
    }
}
