package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@Deprecated
@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.BiomeHumidityCondition")
public class BiomeHumidityCondition extends LootCondition {
    public ResourceLocation biome;

    public BiomeHumidityCondition(){

    }
    @ZenCodeType.Constructor
    public BiomeHumidityCondition(ResourceLocation biome, LootProperty property, ConditionSide side){
        super(property, side);
        this.biome = biome;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.BiomeHumidity;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        Level level = entity.level();
//        level.getBiome(entity.blockPosition()).get().getModifiedClimateSettings()
        return super.isConditionSuccess(entity);
    }
}
