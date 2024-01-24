package net.sdm.sdm_rpg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ItemType;
import net.sdm.sdm_rpg.core.loot.condition.conditions.*;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.loot.result.*;
import net.sdm.sdm_rpg.core.loot.type.LootBlockType;
import net.sdm.sdm_rpg.core.loot.type.LootChestType;
import net.sdm.sdm_rpg.core.loot.type.LootTableType;

import java.util.Collections;
import java.util.Date;

public class SDMTest {


    public static void init(){
        LootProperty property = new LootProperty(new LootTableType(new ResourceLocation("minecraft", "chests/desert_pyramid")));
        property.add(new DimensionCondition(new ResourceLocation("minecraft","overworld"), property));
//
//        property.add(new EntityResult(EntityType.BAT));
        property.add(new ItemResult(Items.BOW.getDefaultInstance()));
//        property.add(new ItemsResult(Collections.singletonList(Items.BOW.getDefaultInstance())));
//        property.add(new LootTableResult(new ResourceLocation("minecraft:entity/cow")));
//        property.add(new MobEffectResult(new MobEffectInstance(MobEffects.ABSORPTION, 20,10)));
        property.saveFile();
        property.create();


//        LootProperty property1 = new LootProperty(new LootEntityType(EntityType.COW));
//        property1.add(new AchievementCondition(new ResourceLocation("test"), property1));
//        property1.add(new DifficultCondition(2,property1));
//        property1.add(new PlayerCountOnThisServerCondition(20,true, property1));
//        property1.add(new PlayerCountBreakBlockCondition(Blocks.DIRT, 10, property1));
//        property1.add(new MobsAroundEntityCondition(EntityType.ARROW,20,2,ConditionSide.ENTITY, property1));
//        property1.create();
//
//        property1 = new LootProperty(new LootFishing(new ResourceLocation("lootpool")));
//        property1.create();
//        property1 = new LootProperty(new LootChestType(new ResourceLocation("minecraft", "chest/dungeon")));
//        property1.create();
    }
}
