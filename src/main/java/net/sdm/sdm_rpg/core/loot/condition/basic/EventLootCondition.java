package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraftforge.eventbus.api.Event;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.basic.EventLootCondition")
public class EventLootCondition extends LootCondition{

    @Override
    public boolean isConditionSuccess(Event event) {
        return super.isConditionSuccess(event);
    }
}
