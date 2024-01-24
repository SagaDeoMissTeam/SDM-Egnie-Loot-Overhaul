package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.ItemType;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/ToolTypeCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.ToolTypeCondition")
public class ToolTypeCondition extends LootCondition {
    public ItemType type;
    public ToolTypeCondition(){}
    public ToolTypeCondition(ItemType type, ConditionSide side, LootProperty property){
        super(property,side);
        this.type = type;
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.ToolType;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            if(player.getMainHandItem().getItem() instanceof AxeItem && type == ItemType.AXE){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof SwordItem && type == ItemType.SWORD){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof PickaxeItem && type == ItemType.PICKAXE){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof ShovelItem && type == ItemType.SHOVEL){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof HoeItem && type == ItemType.HOE){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof BowItem && type == ItemType.BOW){
                return true;
            }
            if(player.getMainHandItem().getItem() instanceof BowItem && type == ItemType.CROSSBOW){
                return true;
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putString("tireType", type.name());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        type = ItemType.valueOf(nbt.getString("tireType"));
    }
}
