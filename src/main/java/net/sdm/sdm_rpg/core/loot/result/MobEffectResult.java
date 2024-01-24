package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/MobEffectResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.MobEffectResult")
public class MobEffectResult extends ILootResult{
    public MobEffectInstance effect;

    public MobEffectResult(){

    }

    @ZenCodeType.Constructor
    public MobEffectResult(MobEffectInstance effect){
        this.effect = effect;
    }

    @Override
    public boolean giveReward(Entity entity, BlockPos pos) {
        if(entity instanceof LivingEntity livingEntity){
            if(!livingEntity.hasEffect(effect.getEffect()))
                return livingEntity.addEffect(effect);
        }
        return false;
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
