package net.sdm.sdm_rpg.core.data.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ItemUseData implements ILootData{
    public UUID player;
    public UUID entity;

    public Date cooldown;
    public List<ItemStack> items = new ArrayList<>();
    public ItemUseData(){

    }

    public ItemUseData addItem(ItemStack item){
        this.items.add(item);
        return this;
    }


    public ItemUseData setPlayer(Player player){
        this.player = player.getUUID();
        return this;
    }
    public ItemUseData setEntity(Entity entity){
        this.entity = entity.getUUID();
        return this;
    }

    public ItemUseData setCooldown(Date cooldown){
        this.cooldown = cooldown;
        return this;
    }

    @Override
    public CompoundTag serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }
}
