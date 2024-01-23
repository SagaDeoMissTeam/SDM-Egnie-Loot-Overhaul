package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerCountOnThisServerCondition")
public class PlayerCountOnThisServerCondition extends LootCondition {

    public int count;
    public boolean isCanBeMore = false;
    public PlayerCountOnThisServerCondition(){}
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(int count, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.count = count;
    }
    @ZenCodeType.Constructor
    public PlayerCountOnThisServerCondition(int count, boolean isCanBeMore, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.count = count;
        this.isCanBeMore = isCanBeMore;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountOnThisServer;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        return isCanBeMore ? entity.level().getServer().getPlayerList().getPlayers().size() >= count : entity.level().getServer().getPlayerList().getPlayers().size() == count;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("count", count);
        nbt.putBoolean("isCanBeMore", isCanBeMore);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        count = nbt.getInt("count");
        isCanBeMore = nbt.getBoolean("isCanBeMore");
    }

}
