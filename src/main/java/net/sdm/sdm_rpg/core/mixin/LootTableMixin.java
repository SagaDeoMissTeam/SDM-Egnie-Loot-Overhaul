package net.sdm.sdm_rpg.core.mixin;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.loot.result.ILootResult;
import net.sdm.sdm_rpg.core.loot.type.LootChestType;
import net.sdm.sdm_rpg.core.loot.type.LootTableType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static net.minecraft.world.level.storage.loot.LootTable.createStackSplitter;

@Mixin(LootTable.class)
public abstract class LootTableMixin {

    @Shadow public abstract ResourceLocation getLootTableId();

    @Shadow @Deprecated public abstract void getRandomItemsRaw(LootContext p_79132_, Consumer<ItemStack> p_79133_);


    @Shadow @Final private List<LootPool> pools;

    @Inject(method = "fill", at = @At("HEAD"), cancellable = true)
    public void sdm$fill(Container container, LootParams lootParams, long l, CallbackInfo ci){
        if(!DataContainer.CHEST_PROPERTY.isEmpty()){
            for (LootProperty property : DataContainer.CHEST_PROPERTY) {
                if(((
                LootChestType)property.type).lootTableID.contains(getLootTableId()) &&
                lootParams.hasParam(LootContextParams.THIS_ENTITY) &&
                lootParams.hasParam(LootContextParams.ORIGIN) &&
                lootParams.getParameter(LootContextParams.THIS_ENTITY) instanceof Player player){

                    BlockPos pos = BlockPos.containing(Objects.requireNonNull(lootParams.getParamOrNull(LootContextParams.ORIGIN)));

                    int success = 0;
                    if(container instanceof BlockEntity chest && chest instanceof RandomizableContainerBlockEntity lootChest){
                        for (LootCondition condition : property.lootConditionList) {
                            if(condition.isConditionSuccess(player)) success++;
                            else {
                                if(property.lootResults.isEmpty()) ci.cancel();
                                return;
                            }
                        }

                        if(success == property.lootConditionList.size()){
                            for (ILootResult s : property.lootResults) {
                                if (!s.giveReward(player, player.blockPosition())) {
                                    if(!s.addToContainer(container)){
                                        s.createOnWorld(chest.getLevel(), new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
                                    }
                                }

                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootContext;)Lit/unimi/dsi/fastutil/objects/ObjectArrayList;", at = @At("HEAD"), cancellable = true)
    private void sdm$getRandomItems(LootContext context, CallbackInfoReturnable<ObjectArrayList<ItemStack>> cir) {
        cir.cancel();
        ObjectArrayList<ItemStack> objectarraylist = new ObjectArrayList<>();
        this.getRandomItemsRaw(context, createStackSplitter(context.getLevel(), objectarraylist::add));
        objectarraylist = net.minecraftforge.common.ForgeHooks.modifyLoot(this.getLootTableId(), objectarraylist, context);

        if(!DataContainer.TABLE_PROPERTY.isEmpty()){
            for (LootProperty property : DataContainer.TABLE_PROPERTY) {
                if(((LootTableType)property.type).lootTable.contains(getLootTableId())){
                    int success = 0;
                    Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
                    Vec3 pos = context.getParamOrNull(LootContextParams.ORIGIN);
                    for (LootCondition condition : property.lootConditionList) {

                        if (entity != null){
                            if (condition.isConditionSuccess(entity)) {
                                success++;
                            } else {
                                if(property.lootResults.isEmpty()) cir.setReturnValue(new ObjectArrayList<>());
                                cir.setReturnValue(objectarraylist);
                                return;
                            }
                        }
                    }

                    if(success == property.lootConditionList.size()){
                        for (ILootResult lootResult : property.lootResults) {
                            if(!lootResult.addToList(objectarraylist)){
                                if(pos != null && !lootResult.createOnWorld(context.getLevel(), BlockPos.containing(pos))){
                                    lootResult.giveReward(entity, BlockPos.containing(pos));
                                }
                            }
                        }
                    }
                }
            }
        }

        cir.setReturnValue(objectarraylist);
    }
}
