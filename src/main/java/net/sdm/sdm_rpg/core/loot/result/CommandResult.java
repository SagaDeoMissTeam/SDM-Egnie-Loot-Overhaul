package net.sdm.sdm_rpg.core.loot.result;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.SDMRPG;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/CommandResult")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.CommandResult")
public class CommandResult extends ILootResult{

    public String command;


    public CommandResult(){

    }
    @ZenCodeType.Constructor
    public CommandResult(String command){
        this.command = command;
    }

    @Override
    public LootResultList getType() {
        return LootResultList.Command;
    }

    @Override
    public boolean giveReward(Entity entity, BlockPos pos) {
        try {
            entity.getCommandSenderWorld().getServer().getCommands().getDispatcher().execute(command, entity.createCommandSourceStack().withSuppressedOutput());
            return true;
        } catch (CommandSyntaxException e) {
            SDMRPG.LOGGER.sendError(e);
            return false;
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
