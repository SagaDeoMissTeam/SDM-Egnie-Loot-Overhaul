package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.sdm.sdm_rpg.core.events.lootOverhaul.CustomConditionEvent;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/CustomCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.CustomCondition")
public class CustomCondition extends LootCondition {

    @ZenCodeType.Field
    public String id;

    @ZenCodeType.Field
    @Nullable public Entity entity;
    @ZenCodeType.Field
    @Nullable public Entity entityKilled;
    @ZenCodeType.Field
    @Nullable public BlockPos pos;
    @ZenCodeType.Field
    @Nullable public Level level;
    @ZenCodeType.Field
    @Nullable public BlockEntity blockEntity;

    @ZenCodeType.Constructor
    public CustomCondition(){}
    @ZenCodeType.Constructor
    public CustomCondition(String id, @Nullable Entity entity,@Nullable Entity entityKilled,@Nullable BlockPos pos,@Nullable Level level,@Nullable BlockEntity blockEntity, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.entity = entity;
        this.entityKilled = entityKilled;
        this.pos = pos;
        this.level = level;
        this.blockEntity = blockEntity;
        this.id = id;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        CustomConditionEvent event = new CustomConditionEvent(id,entity,entityKilled,pos,level,blockEntity, parent.type);
        MinecraftForge.EVENT_BUS.register(event);
        return event.result;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Custom;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("id", id);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        id = nbt.getString("id");
    }
}
