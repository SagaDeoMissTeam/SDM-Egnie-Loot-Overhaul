package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/DifficultCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.DifficultCondition")
public class DifficultCondition extends LootCondition {

    public int difficult;
    public DifficultCondition(){}
    @ZenCodeType.Constructor
    public DifficultCondition(int difficult, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.difficult = difficult;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Difficult;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.level().getServer().getWorldData().getDifficulty().getId() == difficult;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        difficult = nbt.getInt("difficult");
        super.deserializeNBT(nbt);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("difficult", difficult);
        return nbt;
    }
}
