package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import org.openzen.zencode.java.ZenCodeType;

//Количество зачарованных предметов одетых и используются
@ZenRegister
@Deprecated
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerTotalCountEnchantedItemsUseCondition")
public class PlayerTotalCountEnchantedItemsUseCondition extends LootCondition {
    public PlayerTotalCountEnchantedItemsUseCondition(){}
    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerTotalCountEnchantedItemsUse;
    }
}
