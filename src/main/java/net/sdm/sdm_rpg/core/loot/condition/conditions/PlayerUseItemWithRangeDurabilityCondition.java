package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import org.openzen.zencode.java.ZenCodeType;

@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerUseItemWithRangeDurabilityCondition")
public class PlayerUseItemWithRangeDurabilityCondition extends LootCondition {

    public PlayerUseItemWithRangeDurabilityCondition(){}
    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerUseItemWithRangeDurability;
    }
}
