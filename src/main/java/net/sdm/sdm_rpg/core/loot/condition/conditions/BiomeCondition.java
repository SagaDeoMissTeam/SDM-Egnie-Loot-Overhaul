package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
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
@Document("mods/lootoverhaul/loot/condition/BiomeCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.BiomeCondition")
public class BiomeCondition extends LootCondition {
    public ResourceLocation biome;

    public BiomeCondition(){}
    @ZenCodeType.Constructor
    public BiomeCondition(ResourceLocation biome,ConditionSide side, LootProperty property){
        super(property, side);
        this.biome = biome;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        Level level = entity.level();
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            return ForgeRegistries.BIOMES.getKey(level.getBiome(livingEntity.blockPosition()).get()).equals(biome);
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
            return ForgeRegistries.BIOMES.getKey(level.getBiome(livingEntity.blockPosition()).get()).equals(biome);
        }
        return false;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Biome;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        biome = new ResourceLocation(nbt.getString("biome"));
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putString("biome", biome.toString());
        return tag;
    }
}
