package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerLevelCount")
public class PlayerLevelCount extends LootCondition {

    public int level;
    public boolean isCanBeMore;
    public PlayerLevelCount(){}
    public PlayerLevelCount(int level, boolean isCanBeLess, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.level = level;
        this.isCanBeMore = isCanBeLess;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerLevel;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof Player player){
            return isCanBeMore ? player.experienceLevel >= level : player.experienceLevel == level;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("level", level);
        nbt.putBoolean("isCanBeLess", isCanBeMore);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        level = nbt.getInt("level");
        isCanBeMore = nbt.getBoolean("isCanBeLess");
    }
}
