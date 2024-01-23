package net.sdm.sdm_rpg.core.loot.type;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class LootBlock extends LootType{

    public List<Block> blockList = new ArrayList<>();

    public LootBlock(){}
    public LootBlock(Block block){
        blockList.add(block);
    }
    public LootBlock(List<Block> blockList){
        this.blockList = blockList;
    }

    public List<ResourceLocation> getLootTables(){
        return blockList.stream().map(BlockBehaviour::getLootTable).toList();
    }

    @Override
    public LootTypeList getType() {
        return LootTypeList.Block;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt =super.serializeNBT();
        ListTag blocks = new ListTag();
        for (Block block1 : blockList) {
            CompoundTag bk =super.serializeNBT();
            bk.putString("block", ForgeRegistries.BLOCKS.getKey(block1).getNamespace() + ":" + ForgeRegistries.BLOCKS.getKey(block1).getPath());
            blocks.add(bk);
        }
        nbt.put("blocks", blocks);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ListTag tags = nbt.getList("blocks", Tag.TAG_COMPOUND);
        for(int i = 0; i < tags.size(); i++){
            blockList.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(tags.getCompound(i).getString("block"))));
        }
        super.deserializeNBT(nbt);
    }
}
