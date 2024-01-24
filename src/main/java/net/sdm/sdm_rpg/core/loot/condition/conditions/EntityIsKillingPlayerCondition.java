package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityIsKillingPlayerCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityIsKillingPlayerCondition")
public class EntityIsKillingPlayerCondition extends LootCondition {

    public EntityIsKillingPlayerCondition(){}

    public EntityIsKillingPlayerCondition(LootProperty property){
        super(property, ConditionSide.ENTITY);
    }
    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityIsKillingPlayer;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.getPersistentData().contains("killPlayer");
    }
}
