package net.sdm.sdm_rpg.core.loot.condition.integration.scalingheal;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import org.openzen.zencode.java.ZenCodeType;

@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.integration.scalingheal.ScaleDifficultCondition")
public class ScaleDifficultCondition extends LootCondition {

    @Override
    public ConditionsList getType() {
        return ConditionsList.ScaleDifficult;
    }
}
