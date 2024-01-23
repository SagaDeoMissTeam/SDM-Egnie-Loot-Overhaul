package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.ArmorEquipment")
public class ArmorEquipmentCondition extends LootCondition {

    public List<ItemStack> itemStackList = new ArrayList<>();

    public ArmorEquipmentCondition(){}

    @ZenCodeType.Constructor
    public ArmorEquipmentCondition(List<ItemStack> itemStackList, ConditionSide side, LootProperty property){
        super(property, side);
        this.itemStackList = itemStackList;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        int i = 0;
        if(side == ConditionSide.PLAYER && entity instanceof Player player){

            for (ItemStack stack: player.getArmorSlots()) {
                if(itemStackList.contains(stack)) i++;
            }
        } else if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            for (ItemStack stack: livingEntity.getArmorSlots()) {
                if(itemStackList.contains(stack)) i++;
            }
        }
        if(itemStackList.size() == i) return true;
        return false;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.ArmorEquipment;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        ListTag tags = new ListTag();
        for(int i =0 ; i < itemStackList.size(); i++){
            CompoundTag d1 = new CompoundTag();
            NBTUtils.writeItem(d1, "item"+i, itemStackList.get(i));
            tags.add(d1);
        }
        tag.put("items", tags);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag tags = nbt.getList("items", Tag.TAG_COMPOUND);
        for (int i =0; i < tags.size(); i++){
            CompoundTag d1 = (CompoundTag) tags.get(i);
            itemStackList.add(NBTUtils.readItem(d1, "item" + i));

        }
    }
}
