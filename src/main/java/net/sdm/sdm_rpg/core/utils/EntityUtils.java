package net.sdm.sdm_rpg.core.utils;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Objects;

public class EntityUtils {

    /**
     Checks. Whether the entity is in the structure or not.
     * @param structure Structure name
     */
    @ZenCodeType.Method
    public static boolean onStructure(LivingEntity entity, ResourceLocation structure){
        Registry<Structure> registry = entity.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
        ServerLevel level = (ServerLevel) entity.level();
        for(Structure struct : registry){
            if(Objects.equals(registry.getKey(struct), structure)){
                return level.structureManager().getStructureWithPieceAt(entity.blockPosition(), struct).isValid();
            }
        }
        return false;
    }

    /**
     Checks. Whether the entity is in the structure or not.
     * @param structure Structure name
     */
    @ZenCodeType.Method
    public static boolean onStructure(LivingEntity entity, Structure structure){
        Registry<Structure> registry = entity.level().registryAccess().registryOrThrow(Registries.STRUCTURE);
        ServerLevel level = (ServerLevel) entity.level();
        for(Structure struct : registry){
            if(Objects.equals(struct, structure)){
                return level.structureManager().getStructureWithPieceAt(entity.blockPosition(), struct).isValid();
            }
        }
        return false;
    }
}
