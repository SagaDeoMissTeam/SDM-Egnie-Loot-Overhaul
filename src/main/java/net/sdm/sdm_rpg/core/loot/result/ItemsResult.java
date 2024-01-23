package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;

import java.util.List;

public class ItemsResult extends ILootResult{
    public List<ItemStack> item;
    public ItemsResult(){

    }
    public ItemsResult(List<ItemStack> item){
        this.item = item;
    }

    @Override
    public void giveReward(Entity entity, BlockPos pos) {
        if(entity instanceof Player player){
            giveToPlayer(player);
        }
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Items;
    }

    public void giveToPlayer(Player player){
        Inventory inventory = player.getInventory();
        for (ItemStack itemStack : item) {
            if(!inventory.add(itemStack)){
                player.drop(itemStack, false);
            }
        }
    }

    public void dropItem(Player player){
        item.forEach(itemStack -> player.drop(itemStack, false));
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
