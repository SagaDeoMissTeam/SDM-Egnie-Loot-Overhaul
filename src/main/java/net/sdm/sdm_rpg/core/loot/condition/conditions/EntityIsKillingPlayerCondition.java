package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.EntityIsKillingPlayerCondition")
public class EntityIsKillingPlayerCondition extends LootCondition {

    public EntityIsKillingPlayerCondition(){}

    public EntityIsKillingPlayerCondition(ConditionSide side, LootProperty property){
        super(property, side);
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
