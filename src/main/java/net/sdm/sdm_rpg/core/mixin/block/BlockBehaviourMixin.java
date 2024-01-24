package net.sdm.sdm_rpg.core.mixin.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.loot.type.LootBlockType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {

    @Shadow public abstract ResourceLocation getLootTable();

    @Inject(method = "getDrops", at = @At("HEAD"), cancellable = true)
    public void sdm$getDrops(BlockState blockState, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir){
        if(!DataContainer.BLOCKS_PROPERTY.isEmpty()){
            for (LootProperty property : DataContainer.BLOCKS_PROPERTY) {
                if(((LootBlockType)property.type).blockList.contains(blockState.getBlock())){
                    Entity entity = builder.getOptionalParameter(LootContextParams.THIS_ENTITY);
                    if(entity == null) return;
                    int success = 0;
                    for (LootCondition condition : property.lootConditionList) {
                        if(condition.side == ConditionSide.ENTITY && entity instanceof Player player && condition.isConditionSuccess(entity)) success++;
                        else if(condition.side == ConditionSide.PLAYER && entity instanceof LivingEntity livingEntity && condition.isConditionSuccess(entity)) success++;
                        else {
                            if(property.lootResults.isEmpty()) cir.setReturnValue(new ArrayList<>());
                            return;
                        };
                    }
                    if(success != property.lootConditionList.size()){
                        if(property.lootResults.isEmpty()) cir.setReturnValue(new ArrayList<>());

                    } else {
                        property.lootResults.forEach(lootCondition -> {
                            lootCondition.giveReward(entity, entity.blockPosition());
                        });
                    }
                }
            }
        }
    }
}
