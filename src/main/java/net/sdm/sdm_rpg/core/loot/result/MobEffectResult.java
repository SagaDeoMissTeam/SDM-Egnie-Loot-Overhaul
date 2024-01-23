package net.sdm.sdm_rpg.core.loot.result;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;

public class MobEffectResult extends ILootResult{
    public MobEffectInstance effect;

    public MobEffectResult(){

    }

    public MobEffectResult(MobEffectInstance effect){
        this.effect = effect;
    }

    @Override
    public void giveReward(Entity entity, BlockPos pos) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(effect);
        }
    }

    @Override
    public LootResultList getType() {
        return LootResultList.MobEffect;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =super.serializeNBT();
        NBTUtils.writeMobEffectInstance(nbt,"effect", effect);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        effect = NBTUtils.readMobEffectInstance(nbt, "effect");
    }
}
