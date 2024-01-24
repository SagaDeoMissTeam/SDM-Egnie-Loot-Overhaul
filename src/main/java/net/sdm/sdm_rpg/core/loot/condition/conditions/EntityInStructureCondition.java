package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.EntityUtils;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityInStructureCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityInStructureCondition")
public class EntityInStructureCondition extends LootCondition {

    public ResourceLocation structure;
    public EntityInStructureCondition(){}

    public EntityInStructureCondition(ResourceLocation structure, ConditionSide side, LootProperty property){
        super(property, side);
        this.structure = structure;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityInStructure;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return EntityUtils.onStructure(livingEntity, structure);
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
           return EntityUtils.onStructure(player, structure);
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("structure", structure.getNamespace() + ":" + structure.getPath());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        structure = new ResourceLocation(nbt.getString("structure"));
    }
}
