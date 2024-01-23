package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.data.HistoryList;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerPetsKillCondition")
public class PlayerPetsKillCondition extends LootCondition {

    public PlayerPetsKillCondition(){

    }

    public PlayerPetsKillCondition(LootProperty property){
        super(property, ConditionSide.PLAYER);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerPetsKill;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof Player player){
            return !HistoryList.getDate(player.getUUID()).isEmpty();
        }
        return super.isConditionSuccess(entity);
    }
}
