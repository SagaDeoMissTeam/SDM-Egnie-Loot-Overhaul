package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/PlayerHaveBedCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.PlayerHaveBedCondition")
public class PlayerHaveBedCondition extends LootCondition {

    public PlayerHaveBedCondition(){}
    @ZenCodeType.Constructor
    public PlayerHaveBedCondition(LootProperty property){
        super(property, ConditionSide.PLAYER);
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof ServerPlayer player){
            Level level = player.level();
            if(player.getRespawnPosition() == null) return false;
            return level.getBlockState(player.getRespawnPosition()).getBlock() instanceof BedBlock;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerHaveBed;
    }

}
