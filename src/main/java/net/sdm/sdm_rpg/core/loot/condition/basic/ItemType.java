package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/basic/ItemType")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.basic.ItemType")
@BracketEnum("lootoverhaul:itemtype")
public enum ItemType {
    SWORD,
    AXE,
    HOE,
    PICKAXE,
    SHOVEL,
    BOW,
    CROSSBOW;
//    BOOTS,
//    HELMET,
//    CHEST,
//    LEGGINGS,
//    ITEM;
}
