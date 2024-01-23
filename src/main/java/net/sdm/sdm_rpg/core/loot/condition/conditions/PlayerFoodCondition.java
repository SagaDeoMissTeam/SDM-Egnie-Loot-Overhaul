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
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerFoodCondition")
public class PlayerFoodCondition extends LootCondition {

    public int food;
    public boolean isCanBeLess = false;
    public PlayerFoodCondition(){}
    @ZenCodeType.Constructor
    public PlayerFoodCondition(int food, LootProperty property){
        super(property, ConditionSide.PLAYER);
    }
    @ZenCodeType.Constructor
    public PlayerFoodCondition(int food, boolean isCanBeLess, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.isCanBeLess = isCanBeLess;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerFood;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof Player player){
            return isCanBeLess ? player.getFoodData().getFoodLevel() <= food : player.getFoodData().getFoodLevel() == food;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("food", food);
        nbt.putBoolean("isCanBeLess", isCanBeLess);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        food = nbt.getInt("food");
        isCanBeLess = nbt.getBoolean("isCanBeLess");
    }
}
