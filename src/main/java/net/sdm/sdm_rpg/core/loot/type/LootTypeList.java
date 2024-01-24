package net.sdm.sdm_rpg.core.loot.type;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/type/LootTypeList")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.type.LootTypeList")
@BracketEnum("lootoverhaul:loottype")
public enum LootTypeList {

    BLOCK(LootBlockType.class),
    ENTITY(LootEntityType.class),
    CHEST(LootChestType.class),
    TABLE(LootTableType.class),
    FISHING(LootFishingType.class);


    @ZenCodeType.Field
    public Class<? extends LootType> loot;
    LootTypeList(Class<? extends LootType> loot){
        this.loot = loot;
    }
}
