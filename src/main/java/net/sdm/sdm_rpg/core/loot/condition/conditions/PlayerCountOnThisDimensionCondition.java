package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerCountOnThisDimensionCondition")
public class PlayerCountOnThisDimensionCondition extends LootCondition {

    public ResourceLocation dimension;
    public int count;
    public boolean isCanBeMore = false;
    public PlayerCountOnThisDimensionCondition(){}
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension, int count, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.dimension= dimension;
        this.count = count;
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisDimensionCondition(ResourceLocation dimension, int count, boolean isCanBeMore, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.dimension= dimension;
        this.count = count;
        this.isCanBeMore = isCanBeMore;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountOnThisDimension;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        int i = 0;
        if(entity instanceof ServerPlayer player){
            Registry<Level> d1 = entity.level().registryAccess().registryOrThrow(Registries.DIMENSION);
            for(ServerPlayer d2 : player.level().getServer().getPlayerList().getPlayers()){
                if(d2.level() == d1.get(dimension)) i++;
            }
            return isCanBeMore ? i >= count : i == count;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("dimension", dimension.toString());
        nbt.putInt("count", count);
        nbt.putBoolean("isCanBeMore", isCanBeMore);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        dimension = new ResourceLocation(nbt.getString("dimension"));
        count = nbt.getInt("count");
        isCanBeMore = nbt.getBoolean("isCanBeMore");
    }
}
