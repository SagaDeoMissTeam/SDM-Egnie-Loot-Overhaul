package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.PlayerCountBreakBlock")
public class PlayerCountBreakBlockCondition extends LootCondition {
    public Block block;
    public int count;
    public PlayerCountBreakBlockCondition(){}
    @ZenCodeType.Constructor
    public PlayerCountBreakBlockCondition(Block block, int count, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.block= block;
        this.count = count;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof ServerPlayer player){
            return player.getStats().getValue(Stats.BLOCK_MINED.get(block)) >= count;
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.PlayerCountBreakBlock;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("block", block.getDescriptionId());
        nbt.putInt("count", count);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(nbt.getString("block")));
        count = nbt.getInt("count");
    }
}
