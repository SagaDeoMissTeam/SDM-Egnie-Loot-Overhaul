package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityIsUnderwaterCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityIsUnderwaterCondition")
public class EntityIsUnderwaterCondition extends LootCondition {

    public EntityIsUnderwaterCondition(){}
    @ZenCodeType.Constructor
    public EntityIsUnderwaterCondition(ConditionSide side, LootProperty property){
        super(property, side);
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return livingEntity.isUnderWater();
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            return player.isUnderWater();
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityIsUnderwater;
    }
}
