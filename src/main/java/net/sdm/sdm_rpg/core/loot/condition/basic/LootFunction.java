package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/basic/LootFunction")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.basic.LootFunction")
public class LootFunction extends LootCondition{

    public LootFunction(LootProperty property){
        super(property, ConditionSide.FUNCTION);
    }


}
