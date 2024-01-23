package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.HeightCondition")
public class HeightCondition extends LootCondition {
    public int height;

    public HeightCondition(){}
    @ZenCodeType.Constructor
    public HeightCondition(int height, ConditionSide side, LootProperty property){
        super(property,side);
        this.height= height;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return entity.getY() == height;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Height;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("height", height);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        height = nbt.getInt("height");
    }
}
