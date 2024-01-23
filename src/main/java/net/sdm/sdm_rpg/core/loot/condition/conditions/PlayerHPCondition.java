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
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerHPCondition")
public class PlayerHPCondition extends LootCondition {

    public float hp;
    public boolean isCanBeLess;
    public PlayerHPCondition(){}
    public PlayerHPCondition(float hp, boolean isCanBeLess, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.hp = hp;
        this.isCanBeLess = isCanBeLess;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerHP;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof Player player){
            return isCanBeLess ? player.getHealth() <= hp : player.getHealth() == hp;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putFloat("hp", hp);
        nbt.putBoolean("isCanBeLess", isCanBeLess);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        hp = nbt.getFloat("hp");
        isCanBeLess = nbt.getBoolean("isCanBeLess");
    }
}
