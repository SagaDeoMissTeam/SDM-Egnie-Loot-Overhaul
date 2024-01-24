package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Objects;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/DimensionCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.DimensionCondition")
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
        if(d1.get(dimension) == null) {
            String message = "";
            message += "Condition File -> " + (parent.fileName.isEmpty() ? parent.id : parent.fileName) + "\n";
            message += "DimensionCondition has error\n";
            message += "   \"dimension is null\".\n";
            message += "Please check that the measurement ID is correct";
            SDMRPG.LOGGER.sendError(message);
        }

        return entity.level().dimension().location().equals(dimension);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeResourceLocation(nbt, "dimension", dimension);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        dimension = NBTUtils.readResourceLocation(nbt, "dimension");
    }
}
