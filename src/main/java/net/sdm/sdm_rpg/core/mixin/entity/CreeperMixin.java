package net.sdm.sdm_rpg.core.mixin.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.common.MinecraftForge;
import net.sdm.sdm_rpg.core.data.ISDMDataHelper;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.data.SDMLevelSavedData;
import net.sdm.sdm_rpg.core.events.lootOverhaul.ExplodeCreeperEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public class CreeperMixin {

    @Shadow private int explosionRadius;

    @Inject(method = "explodeCreeper", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Creeper;spawnLingeringCloud()V"))
    public void explodeCreeper(CallbackInfo ci){
        ServerLevel level = ((Creeper)(Object)this).level().getServer().overworld();;
        SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();
        if(!data.getData().contains("creeperDetonation")){
            data.getData().putInt("creeperDetonation", 1);
            LevelInfo.creeperDetonation = 1;
        }
        else {
            data.getData().putInt("creeperDetonation", data.getData().getInt("creeperDetonation")+1);
            LevelInfo.creeperDetonation++;
        }

        MinecraftForge.EVENT_BUS.register(new ExplodeCreeperEvent((Creeper)(Object)this, this.explosionRadius, LevelInfo.INSTANCE));
    }
}
