package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerFoodEatCondition")
public class PlayerFoodEatCondition extends LootCondition {

    public int count;
    public PlayerFoodEatCondition(){}
    @ZenCodeType.Constructor
    public PlayerFoodEatCondition(int count, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.count = count;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerFoodEat;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof Player player){

        }
        return super.isConditionSuccess(entity);
    }
}
