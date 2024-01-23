package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.MobAround")
public class MobsAroundEntityCondition extends LootCondition {
    public EntityType<?> entityType;
    public int count;
    public int zone;
    public MobsAroundEntityCondition(){}
    @ZenCodeType.Constructor
    public MobsAroundEntityCondition(EntityType<?> entityType, int count, int zone, ConditionSide side, LootProperty property){
        super(property,side);
        this.entityType = entityType;
        this.count = count;
        this.zone = zone;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.MobsAroundEntity;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            int i = 0;
            BlockPos pos1 = new BlockPos(entity.blockPosition().getX() - zone, entity.blockPosition().getY() - zone, entity.blockPosition().getZ() - zone);
            BlockPos pos2 = new BlockPos(entity.blockPosition().getX() + zone, entity.blockPosition().getY() + zone, entity.blockPosition().getZ() + zone);
            for(Entity d1 : livingEntity.level().getEntities(entity, AABB.of(new BoundingBox(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ())))){
                if(d1.getType().equals(entityType)) i++;
            }
            return i >= count;
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player livingEntity){
            int i = 0;
            BlockPos pos1 = new BlockPos(entity.blockPosition().getX() - zone, entity.blockPosition().getY() - zone, entity.blockPosition().getZ() - zone);
            BlockPos pos2 = new BlockPos(entity.blockPosition().getX() + zone, entity.blockPosition().getY() + zone, entity.blockPosition().getZ() + zone);
            for(Entity d1 : livingEntity.level().getEntities(entity, AABB.of(new BoundingBox(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ())))){
                if(d1.getType().equals(entityType)) i++;
            }
            return i >= count;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("entityType", ForgeRegistries.ENTITY_TYPES.getKey(entityType).getNamespace() + ":" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
        nbt.putInt("count", count);
        nbt.putInt("zone", zone);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        entityType = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(nbt.getString("entityType")));
        count = nbt.getInt("count");
        zone = nbt.getInt("zone");
    }
}
