package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

//количество Убито конкретного моба

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/PlayerEntityKillCountCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.PlayerEntityKillCountCondition")
public class PlayerEntityKillCountCondition extends LootCondition {

    public EntityType<?> entityType;
    public int count;
    public PlayerEntityKillCountCondition(){}
    @ZenCodeType.Constructor
    public PlayerEntityKillCountCondition(EntityType<?> entityType, int count, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.entityType = entityType;
        this.count = count;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerEntityKillCount;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof ServerPlayer player){
            return player.getStats().getValue(Stats.ENTITY_KILLED.get(entityType)) >= count;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        NBTUtils.writeEntity(nbt,"entityType", entityType);
        nbt.putInt("count", count);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);

        entityType = NBTUtils.readEntity(nbt, "entityType");
        count = nbt.getInt("count");
    }
}
