package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sdmrpg.loot.condition.CountCurrentBlockAroundEntityCondition")
public class CountCurrentBlockAroundEntityCondition extends LootCondition {
    public Block block;
    public int count;
    public int zone;

    public CountCurrentBlockAroundEntityCondition(){

    }
    @ZenCodeType.Constructor
    public CountCurrentBlockAroundEntityCondition(Block block, int count, ConditionSide side, LootProperty property){
        super(property, side);
        this.block = block;
        this.side = side;
        this.count = count;
        this.zone = 8;
    }
    @ZenCodeType.Constructor
    public CountCurrentBlockAroundEntityCondition(Block block, int count, int zone, ConditionSide side, LootProperty property){
        super(property, side);
        this.block = block;
        this.count = count;
        this.zone = zone;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.CountCurrentBlockAroundEntity;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity){
            return getCountBlocks(entity.level(), entity.blockPosition()) >= count;
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player){
            return getCountBlocks(entity.level(), entity.blockPosition()) >= count;
        }
        return super.isConditionSuccess(entity);
    }


    private int getCountBlocks(Level level, BlockPos pos){
        int x1 = pos.getX() - zone;
        int y1 = pos.getY() - zone;
        int z1 = pos.getZ() - zone;
        int x2 = pos.getX() + zone;
        int y2 = pos.getY() + zone;
        int z2 = pos.getZ() + zone;

        int i = 0;

        while (x1 <= x2){
            while (y1 <= y2){
                while (z1 <= z2){
                    if(level.getBlockState(new BlockPos(x1,y1,z1)).getBlock().equals(block)) i++;
                    z2++;
                }
                y1++;
                z1 = pos.getZ() - zone;
            }
            x1++;
            y1 = pos.getY() - zone;
        }
        return i;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putString("block", block.getDescriptionId());
        tag.putInt("count", count);
        tag.putInt("zone", zone);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(nbt.getString("block")));
        count = nbt.getInt("count");
        zone = nbt.getInt("zone");
    }
}
