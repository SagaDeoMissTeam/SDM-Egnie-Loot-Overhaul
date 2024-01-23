package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;

public class ItemResult extends ILootResult{

    public ItemStack item;
    public ItemResult(){

    }
    public ItemResult(ItemStack item){
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
        return LootResultList.Item;
    }

    public void giveToPlayer(Player player){
        if(!player.getInventory().add(item)){
            dropItem(player);
        }
    }
    public void dropItem(Player player){
        player.drop(item, false);
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
