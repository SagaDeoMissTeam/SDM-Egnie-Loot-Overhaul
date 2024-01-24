package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityOnBlockCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityOnBlockCondition")
public class EntityOnBlockCondition extends LootCondition {
    public EntityOnBlockCondition(){}
    @ZenCodeType.Constructor
    public EntityOnBlockCondition(ConditionSide side, LootProperty property){
        super(property, side);
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.onGround();
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityOnBlock;
    }
}
