package net.sdm.sdm_rpg.core.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.result.ILootResult;
import net.sdm.sdm_rpg.core.loot.type.LootFishingType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

@Mixin(FishingHook.class)
public abstract class FishingHookMixin {


    @Shadow @Nullable public abstract Player getPlayerOwner();

    @Shadow protected abstract boolean shouldStopFishing(Player p_37137_);

    @Shadow @Nullable private Entity hookedIn;

    @Shadow protected abstract void pullEntity(Entity p_150156_);

    @Shadow private int nibble;

    @Shadow @Final private int luck;

    @Inject(method = "retrieve", at = @At(value = "HEAD"), cancellable = true)
    public void sdm$retrieve(ItemStack p_37157_, CallbackInfoReturnable<Integer> cir){
        Player player = this.getPlayerOwner();
        if (!((FishingHook)(Object)this).level().isClientSide && player != null && !this.shouldStopFishing(player)) {
            int i = 0;
            net.minecraftforge.event.entity.player.ItemFishedEvent event = null;
            if (this.hookedIn != null) {
                this.pullEntity(this.hookedIn);
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer)player, p_37157_, ((FishingHook)(Object)this), Collections.emptyList());
                ((FishingHook)(Object)this).level().broadcastEntityEvent(((FishingHook)(Object)this), (byte)31);
                i = this.hookedIn instanceof ItemEntity ? 3 : 5;
            } else if (this.nibble > 0) {
                LootParams lootparams = (new LootParams.Builder((ServerLevel)((FishingHook)(Object)this).level())).withParameter(LootContextParams.ORIGIN, ((FishingHook)(Object)this).position()).withParameter(LootContextParams.TOOL, p_37157_).withParameter(LootContextParams.THIS_ENTITY, ((FishingHook)(Object)this)).withParameter(LootContextParams.KILLER_ENTITY, ((FishingHook)(Object)this).getOwner()).withParameter(LootContextParams.THIS_ENTITY, ((FishingHook)(Object)this)).withLuck((float)this.luck + player.getLuck()).create(LootContextParamSets.FISHING);
                LootTable loottable = ((FishingHook)(Object)this).level().getServer().getLootData().getLootTable(BuiltInLootTables.FISHING);
                List<ItemStack> list = loottable.getRandomItems(lootparams);
                event = new net.minecraftforge.event.entity.player.ItemFishedEvent(list, ((FishingHook)(Object)this).onGround() ? 2 : 1, ((FishingHook)(Object)this));
                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
                if (event.isCanceled()) {
                    ((FishingHook)(Object)this).discard();
                    cir.setReturnValue(event.getRodDamage());
                }
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer)player, p_37157_, ((FishingHook)(Object)this), list);

                if(!DataContainer.FISH_PROPERTY.isEmpty()){
                    for (LootProperty property : DataContainer.FISH_PROPERTY) {
                        if(((LootFishingType)property.type).resourceLocations.contains(loottable.getLootTableId())){
                            int success = 0;
                            for (LootCondition condition : property.lootConditionList) {
                                if(condition.isConditionSuccess(player)){
                                    success++;
                                } else {
                                    if(!property.lootResults.isEmpty()) list.clear();
                                    break;
                                }
                            }

                            if(success == property.lootConditionList.size()){
                                for (ILootResult lootResult : property.lootResults) {
                                    if(!lootResult.addToList(list)){
                                        if(!lootResult.createOnWorld(((FishingHook)(Object)this).level(), ((FishingHook)(Object)this).blockPosition())){
                                            if(!lootResult.giveReward(player, ((FishingHook)(Object)this).blockPosition())){
                                                lootResult.addToContainer(player.getInventory());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                for(ItemStack itemstack : list) {
                    ItemEntity itementity = new ItemEntity(((FishingHook)(Object)this).level(), ((FishingHook)(Object)this).getX(), ((FishingHook)(Object)this).getY(), ((FishingHook)(Object)this).getZ(), itemstack);
                    double d0 = player.getX() - ((FishingHook)(Object)this).getX();
                    double d1 = player.getY() - ((FishingHook)(Object)this).getY();
                    double d2 = player.getZ() - ((FishingHook)(Object)this).getZ();
                    double d3 = 0.1D;
                    itementity.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                    ((FishingHook)(Object)this).level().addFreshEntity(itementity);
                    player.level().addFreshEntity(new ExperienceOrb(player.level(), player.getX(), player.getY() + 0.5D, player.getZ() + 0.5D, ((FishingHook)(Object)this).level().random.nextInt(6) + 1));
                    if (itemstack.is(ItemTags.FISHES)) {
                        player.awardStat(Stats.FISH_CAUGHT, 1);
                    }
                }

                i = 1;
            }

            if (((FishingHook)(Object)this).onGround()) {
                i = 2;
            }

            ((FishingHook)(Object)this).discard();
            cir.setReturnValue(event == null ? i : event.getRodDamage());
        } else {
            cir.setReturnValue(0);
        }
    }
}
