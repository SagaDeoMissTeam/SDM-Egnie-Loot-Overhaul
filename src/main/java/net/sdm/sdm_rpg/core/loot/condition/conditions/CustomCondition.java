package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.CustomCondition")
public class CustomCondition extends LootCondition {

    @ZenCodeType.Field
    public int id;

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


    private Consumer<CustomCondition> consumer = s -> {};
    @ZenCodeType.Field
    public boolean isSuccess = false;

    public CustomCondition(){}
    @ZenCodeType.Constructor
    public CustomCondition(int id, @Nullable Entity entity,@Nullable Entity entityKilled,@Nullable BlockPos pos,@Nullable Level level,@Nullable BlockEntity blockEntity, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.entity = entity;
        this.entityKilled = entityKilled;
        this.pos = pos;
        this.level = level;
        this.blockEntity = blockEntity;
        this.id = id;
    }

    @ZenCodeType.Method
    public void custom(Consumer<CustomCondition> consumer){
        this.consumer = consumer;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        consumer.accept(this);
        return isSuccess;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Custom;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("id", id);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        id = nbt.getInt("id");
    }
}
