package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.eventbus.api.Event;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.jetbrains.annotations.NotNull;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.basic.LootCondition")
public class LootCondition implements INBTSerializable<CompoundTag>, ICondition<LootCondition> {
    public int priority = 0;
    public LootProperty parent;
    public ConditionSide side;

    @ZenCodeType.Constructor
    public LootCondition(LootProperty parent, ConditionSide side){
        this.parent = parent;
        this.side = side;
    }

    @ZenCodeType.Constructor
    public LootCondition(){
        parent = null;
        this.side = ConditionSide.NONE;
    }

    @ZenCodeType.Method
    public boolean isConditionSuccess(Entity entity){
        return false;
    }
    @ZenCodeType.Method
    public boolean isConditionSuccess(Event event) {return false;}
    @ZenCodeType.Method
    public ConditionSide getSide(){
        return side;
    }

    @ZenCodeType.Method
    public int getPriority() {
        return priority;
    }

    public ConditionsList getType(){
        return null;
    }

    @ZenCodeType.Method
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("type", getType().name());
        tag.putString("side", side.name);
        tag.putInt("priority", priority);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        side = nbt.getString("side").contains("player") ? ConditionSide.PLAYER : nbt.getString("side").contains("entity") ? ConditionSide.ENTITY : nbt.getString("side").contains("function") ? ConditionSide.FUNCTION : ConditionSide.NONE;
        priority = nbt.getInt("priority");
    }

    @Override
    public LootCondition createDefaultInstance() {
        return new LootCondition();
    }
}
