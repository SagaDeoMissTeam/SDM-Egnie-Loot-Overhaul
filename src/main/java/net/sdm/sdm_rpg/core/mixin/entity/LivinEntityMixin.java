package net.sdm.sdm_rpg.core.mixin.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.loot.result.ILootResult;
import net.sdm.sdm_rpg.core.loot.type.LootEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivinEntityMixin {


    @Shadow public abstract ResourceLocation getLootTable();

    @Shadow public abstract void remove(Entity.RemovalReason p_276115_);

    @Inject(method = "dropFromLootTable", at = @At("HEAD"), cancellable = true)
    protected void sdm$dropFromLootTable(DamageSource damageSource, boolean p_21022_, CallbackInfo ci){

        if(!DataContainer.ENTITY_PROPERTY.isEmpty()){

            for (LootProperty property : DataContainer.ENTITY_PROPERTY) {

                if(((LootEntityType)property.type).entityTypeList.contains(((LivingEntity)(Object)this).getType())) {

                    int success = 0;

                    for (LootCondition condition : property.lootConditionList) {

                        if (damageSource.getEntity() instanceof Player player)

                            if (condition.side == ConditionSide.PLAYER && condition.isConditionSuccess(player)) {
                                success++;
                            } else if (condition.side == ConditionSide.ENTITY && condition.isConditionSuccess((LivingEntity) (Object) this))
                                success++;

                            else if (condition.isConditionSuccess((LivingEntity) (Object) this)) success++;

                            else if (condition.isConditionSuccess(player)) success++;
                            else {
                                if(property.lootResults.isEmpty()) ci.cancel();
                                return;
                            }
                    }
                    if(success == property.lootConditionList.size()){

                        property.lootResults.forEach(s -> {

                            s.giveReward(damageSource.getEntity() instanceof Player ? damageSource.getEntity() : (LivingEntity)(Object)this, damageSource.getEntity() instanceof Player ? damageSource.getEntity().blockPosition() : ((LivingEntity)(Object)this).blockPosition());
                        });

                    } else {

                        if (property.lootResults.isEmpty()) ci.cancel();
                    }
                }
            }
        }
    }

}
