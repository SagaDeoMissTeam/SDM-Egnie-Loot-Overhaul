package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import org.openzen.zencode.java.ZenCodeType;

//Статистика игрока
@ZenRegister
@Deprecated
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerStatsCondition")
public class PlayerStatsCondition extends LootCondition {
    public PlayerStatsCondition(){}
    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerStats;
    }
}
