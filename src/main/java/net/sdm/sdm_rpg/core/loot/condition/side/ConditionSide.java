package net.sdm.sdm_rpg.core.loot.condition.side;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.side.ConditionSide")
@BracketEnum("sdmrpg:side")
public enum ConditionSide {

    NONE("none"),
    FUNCTION("function"),
    PLAYER("player"),
    ENTITY("entity");


    @ZenCodeType.Field
    public String name;
    ConditionSide(String name){
        this.name =name;
    }
}
