package net.sdm.sdm_rpg.core.loot.condition.basic;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/basic/ICondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.basic.ICondition")
public interface ICondition<T extends LootCondition>{


    public T createDefaultInstance();
}
