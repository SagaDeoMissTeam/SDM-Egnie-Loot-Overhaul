package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.BiomeTemperatureCondition")
public class BiomeTemperatureCondition extends LootCondition {
    public float temperature;

    public BiomeTemperatureCondition(){

    }
    @ZenCodeType.Constructor
    public BiomeTemperatureCondition(float temperature, ConditionSide side, LootProperty property){
        super(property, side);
        this.temperature = temperature;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        Level level = entity.level();
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return level.getBiome(livingEntity.blockPosition()).get().getModifiedClimateSettings().temperature() == temperature;
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
            return level.getBiome(livingEntity.blockPosition()).get().getModifiedClimateSettings().temperature() == temperature;
        }
        return false;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.BiomeTemperature;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        temperature = nbt.getFloat("temperature");
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putFloat("temperature", temperature);
        return nbt;
    }
}
