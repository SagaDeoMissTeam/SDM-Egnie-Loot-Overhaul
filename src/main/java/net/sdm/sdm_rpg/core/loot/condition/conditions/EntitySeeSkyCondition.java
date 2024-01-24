package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntitySeeSkyCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntitySeeSkyCondition")
public class EntitySeeSkyCondition extends LootCondition {
    public EntitySeeSkyCondition(){}
    @ZenCodeType.Constructor
    public EntitySeeSkyCondition(ConditionSide side, LootProperty property){
        super(property, side);
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
           return livingEntity.level().canSeeSky(livingEntity.blockPosition());
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
           return livingEntity.level().canSeeSky(livingEntity.blockPosition());
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntitySeeSky;
    }
}
