package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraftforge.eventbus.api.Event;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/basic/EventLootCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.basic.EventLootCondition")
public class EventLootCondition extends LootCondition{

    @Override
    public boolean isConditionSuccess(Event event) {
        return super.isConditionSuccess(event);
    }
}
