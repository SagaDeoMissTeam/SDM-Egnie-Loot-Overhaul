package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityRideCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityRideCondition")
public class EntityRideCondition extends LootCondition {
    public EntityRideCondition(){}
    public EntityRideCondition(LootProperty property){
        super(property, ConditionSide.ENTITY);
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityRide;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
           return livingEntity.isPassenger();
        }
        return super.isConditionSuccess(entity);
    }
}
