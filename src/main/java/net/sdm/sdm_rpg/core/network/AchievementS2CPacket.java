package net.sdm.sdm_rpg.core.network;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class AchievementS2CPacket {
    public ResourceLocation achievement;
    public Boolean isHave = false;
    public AchievementS2CPacket(ResourceLocation achievement){
        this.achievement = achievement;
        this.isHave = false;
    }
    public AchievementS2CPacket(FriendlyByteBuf buf){
        this.achievement = buf.readResourceLocation();
        this.isHave = false;
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeResourceLocation(achievement);
        buf.writeBoolean(isHave);
    }

    public boolean handler(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

        });

        return true;
    }
}
