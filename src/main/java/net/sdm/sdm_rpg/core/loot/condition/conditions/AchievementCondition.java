package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.snbt.SNBTCompoundTag;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/AchievementCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.AchievementCondition")
public class AchievementCondition extends LootCondition {
    public ResourceLocation advancement;

    public AchievementCondition(){

    }

    @ZenCodeType.Constructor
    public AchievementCondition(ResourceLocation advancement, LootProperty property){
        super(property, ConditionSide.PLAYER);
        this.advancement = advancement;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(entity instanceof ServerPlayer player){
            Advancement d1 = player.server.getAdvancements().getAdvancement(advancement);
            if(d1 == null)
                return false;

            AdvancementProgress progress = player.getAdvancements().getOrStartProgress(d1);
            return progress.isDone();
        }
        return false;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Achievement;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putString("advancement", advancement.toString());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        advancement = new ResourceLocation(nbt.getString("advancement"));
    }
}
