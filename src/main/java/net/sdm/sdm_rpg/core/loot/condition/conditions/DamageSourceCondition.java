package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;


@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.DamageSourceCondition")
public class DamageSourceCondition extends LootCondition {
    public DamageSource damageSource;

    public DamageSourceCondition(){}
    @ZenCodeType.Constructor
    public DamageSourceCondition(DamageSource damageSource, LootProperty property){
        super(property, ConditionSide.ENTITY);
        this.damageSource = damageSource;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.DamageSource;
    }

    @Override
    public boolean isConditionSuccess(Event event) {
        if(event instanceof LivingDamageEvent damageEvent){

        }
        return super.isConditionSuccess(event);
    }
}
