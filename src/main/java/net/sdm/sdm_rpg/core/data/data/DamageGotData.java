package net.sdm.sdm_rpg.core.data.data;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Date;
import java.util.UUID;

//@ZenRegister
//@Document("mods/lootoverhaul/data/data/DamageGotData")
//@ZenCodeType.Name("mods.lootoverhaul.data.data.DamageGotData")
public class DamageGotData implements ILootData{

    public UUID player;

    public UUID entity;
    public double damage = 0;
    public Date coolDown;

    public DamageGotData(){

    }

    public DamageGotData(Player player, Entity entity, double damage, Date date){
        this.player = player.getUUID();
        this.entity = entity.getUUID();
        this.damage += damage;
        this.coolDown = date;
    }

    public DamageGotData addDamage(double damage){
        this.damage += damage;
        return this;
    }

    public DamageGotData setPlayer(Player player){
        this.player = player.getUUID();
        return this;
    }
    public DamageGotData setEntity(Entity entity){
        this.entity = entity.getUUID();
        return this;
    }

    public DamageGotData addCoolDown(long coolDown){
        this.coolDown = new Date(this.coolDown.getTime() + coolDown);
        return this;
    }

    public DamageGotData setCooldown(Date cooldown){
        this.coolDown = cooldown;
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
