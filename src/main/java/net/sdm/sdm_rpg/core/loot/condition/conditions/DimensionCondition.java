package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.DimensionCondition")
public class DimensionCondition extends LootCondition {
    public ResourceLocation dimension;
    public DimensionCondition(){}
    @ZenCodeType.Constructor
    public DimensionCondition(ResourceLocation dimension, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.dimension = dimension;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Dimension;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        Registry<Level> d1 = entity.level().registryAccess().registryOrThrow(Registries.DIMENSION);
        return d1.getKey(d1.get(entity.level().dimension())) == dimension;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("dimension", dimension.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        dimension = new ResourceLocation(nbt.getString("dimension"));
    }
}
