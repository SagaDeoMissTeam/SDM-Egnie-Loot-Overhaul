package net.sdm.sdm_rpg.core.loot.result;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class CommandResult extends ILootResult{

    public String command;

    public CommandResult(){

    }
    public CommandResult(String command){
        this.command = command;
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Command;
    }

    @Override
    public void giveReward(Entity entity, BlockPos pos) {
        try {
            entity.getCommandSenderWorld().getServer().getCommands().getDispatcher().execute(command, entity.createCommandSourceStack().withSuppressedOutput());
        } catch (CommandSyntaxException e) {
            //TODO : Add ERROR !
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putString("command", command);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        command = nbt.getString("command");
    }
}
