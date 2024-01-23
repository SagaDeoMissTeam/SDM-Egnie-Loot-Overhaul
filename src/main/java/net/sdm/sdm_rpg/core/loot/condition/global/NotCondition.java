package net.sdm.sdm_rpg.core.loot.condition.global;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.eventbus.api.Event;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootFunction;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.global.NotCondition")
public class NotCondition extends LootFunction {

    public LootCondition condition;

    public NotCondition(){
        super(null);
    }

    public NotCondition(LootCondition condition, LootProperty property){
        super(property);
        this.condition = condition;
    }


    @Override
    public ConditionsList getType() {
        return ConditionsList.Not;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return !condition.isConditionSuccess(entity);
    }

    @Override
    public boolean isConditionSuccess(Event event) {
        return !condition.isConditionSuccess(event);
    }


    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.put("conditions", condition.serializeNBT());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        LootCondition cd = new LootCondition();
        cd.parent = parent;
        cd.deserializeNBT(nbt.getCompound("conditions"));
        condition = cd;
    }
}
