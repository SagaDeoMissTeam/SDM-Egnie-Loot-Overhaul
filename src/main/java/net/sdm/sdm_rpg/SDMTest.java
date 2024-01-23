package net.sdm.sdm_rpg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.conditions.*;
import net.sdm.sdm_rpg.core.loot.condition.global.AndCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.loot.result.CommandResult;
import net.sdm.sdm_rpg.core.loot.result.EntityResult;
import net.sdm.sdm_rpg.core.loot.result.ItemResult;
import net.sdm.sdm_rpg.core.loot.result.MobEffectResult;
import net.sdm.sdm_rpg.core.loot.type.LootBlock;
import net.sdm.sdm_rpg.core.loot.type.LootEntityType;

import java.util.Date;

public class SDMTest {


    public static void init(){
        LootProperty property = new LootProperty(new LootBlock(Blocks.DIRT));
        property.add(new BiomeCondition(new ResourceLocation("test"), ConditionSide.PLAYER,property));
        property.add(new EntityInFireCondition(ConditionSide.PLAYER, property));
        property.add(new RealDateCondition(new Date(System.currentTimeMillis()), property));
        property.add(new PlayerHPCondition(10, true, property));
        property.add(new RandomNumberCondition(10,20,2, property));
        property.add(
                new AndCondition()
                        .add(new BiomeCondition(new ResourceLocation("test"), ConditionSide.PLAYER,property))
                        .add(new PlayerHPCondition(10, true, property))
                        .add(new DifficultCondition(2,property))
                        .add(new MobsAroundEntityCondition(EntityType.ARROW,20,2,ConditionSide.ENTITY, property))
                        .add(new AndCondition()
                                .add(new BiomeCondition(new ResourceLocation("test"), ConditionSide.PLAYER,property))
                                .add(new PlayerHPCondition(10, true, property))
                                .add(new DifficultCondition(2,property))
                                .add(new MobsAroundEntityCondition(EntityType.ARROW,20,2,ConditionSide.ENTITY, property))
                                .add(new AndCondition()
                                        .add(new BiomeCondition(new ResourceLocation("test"), ConditionSide.PLAYER,property))
                                        .add(new PlayerHPCondition(10, true, property))
                                        .add(new DifficultCondition(2,property))
                                        .add(new MobsAroundEntityCondition(EntityType.ARROW,20,2,ConditionSide.ENTITY, property))))
        );
        property.add(new CommandResult("/time set day"));
        property.add(new CommandResult("/time set hello"));
        property.add(new ItemResult(Items.ACACIA_LOG.getDefaultInstance()));
        property.add(new EntityResult(EntityType.BAT));
        property.add(new MobEffectResult(new MobEffectInstance(MobEffects.ABSORPTION, 10,20)));
        property.create();
        LootProperty property1 = new LootProperty(new LootEntityType(EntityType.COW));
        property1.add(new AchievementCondition(new ResourceLocation("test"), property1));
        property1.add(new DifficultCondition(2,property1));
        property1.add(new PlayerCountOnThisServerCondition(20,true, property1));
        property1.add(new PlayerCountBreakBlockCondition(Blocks.DIRT, 10, property1));
        property1.add(new MobsAroundEntityCondition(EntityType.ARROW,20,2,ConditionSide.ENTITY, property1));
        property1.create();
    }
}
