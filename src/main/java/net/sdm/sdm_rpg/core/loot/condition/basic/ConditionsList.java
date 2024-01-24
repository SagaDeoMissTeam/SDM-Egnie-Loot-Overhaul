package net.sdm.sdm_rpg.core.loot.condition.basic;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.sdm.sdm_rpg.core.loot.condition.conditions.*;
import net.sdm.sdm_rpg.core.loot.condition.global.AndCondition;
import net.sdm.sdm_rpg.core.loot.condition.global.NotCondition;
import net.sdm.sdm_rpg.core.loot.condition.global.OrCondition;
import net.sdm.sdm_rpg.core.loot.condition.integration.pmmo.PMMOLevelCondition;
import net.sdm.sdm_rpg.core.loot.condition.integration.scalingheal.ScaleDifficultCondition;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/basic/ConditionsList")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.basic.ConditionsList")
@BracketEnum("lootoverhaul:conditions")
public enum ConditionsList {
    Achievement(AchievementCondition.class),
    ArmorEquipment(ArmorEquipmentCondition.class),
    Biome(BiomeCondition.class),
    BiomeHumidity(BiomeHumidityCondition.class),
    BiomeTemperature(BiomeTemperatureCondition.class),
    CountCurrentBlockAroundEntity(CountCurrentBlockAroundEntityCondition.class),
    CountGrownPlants(CountGrownPlantsCondition.class),
    CountKilledEnderDragon(CountKilledEnderDragonCondition.class),
    Custom(CustomCondition.class),
    DamageSource(DamageSourceCondition.class),
    Difficult(DifficultCondition.class),
    Dimension(DimensionCondition.class),
    EntityComboKill(EntityComboKillCondition.class),
    EntityGotDamage(EntityGotDamageCondition.class),
    EntityHasEffect(EntityHasEffectCondition.class),
    EntityInFire(EntityInFireCondition.class),
    EntityInStructure(EntityInStructureCondition.class),
    EntityIsKillingPlayer(EntityIsKillingPlayerCondition.class),
    EntityIsUnderwater(EntityIsUnderwaterCondition.class),
    EntityOnAir(EntityOnAirCondition.class),
    EntityOnBlock(EntityOnBlockCondition.class),
    EntityRide(EntityRideCondition.class),
    EntitySeeSky(EntitySeeSkyCondition.class),
    PlayerSequenceKillEntity(PlayerSequenceKillEntityCondition.class),
    EntityTimeInStructure(EntityTimeInStructureCondition.class),
    GameCurrentDay(GameCurrentDayCondition.class),
    GameDay(GameDayCondition.class),
    GameStage(GameStageCondition.class),
    Height(HeightCondition.class),
    ItemInHand(ItemInHandCondition.class),
    ItemInInventory(ItemInInventoryCondition.class),
    ItemInSlot(ItemInSlotCondition.class),
    LightLevel(LightLevelCondition.class),
    MobsAroundEntity(MobsAroundEntityCondition.class),
    NumberOfCreeperDetonations(NumberOfCreeperDetonationsCondition.class),
    NumberOfSkeletonsKilledByEachOther(NumberOfSkeletonsKilledByEachOtherCondition.class),
    PlayerClass(PlayerClassCondition.class),
    PlayerCountBreakBlock(PlayerCountBreakBlockCondition.class),
    PlayerCountOnThisDimension(PlayerCountOnThisDimensionCondition.class),
    PlayerCountOnThisServer(PlayerCountOnThisServerCondition.class),
    PlayerCountSleepingNights(PlayerCountSleepingNightsCondition.class),
    PlayerCountUseItemOnBattle(PlayerCountUseItemOnBattleCondition.class),
    PlayerData(PlayerDataCondition.class),
    PlayerDeadCount(PlayerDeadCountCondition.class),
    PlayerEntityKillCount(PlayerEntityKillCountCondition.class),
    PlayerFood(PlayerFoodCondition.class),
    PlayerFoodEat(PlayerFoodEatCondition.class),
    PlayerGotDamageOnBattle(PlayerGotDamageOnBattleCondition.class),
    PlayerHaveBed(PlayerHaveBedCondition.class),
    PlayerHP(PlayerHPCondition.class),
    PlayerLevel(PlayerLevelCount.class),
    PlayerPetsKill(PlayerPetsKillCondition.class),
    PlayerRideKill(PlayerRideKillCondition.class),
    PlayerStats(PlayerStatsCondition.class),
    PlayerTotalCountEnchantedItemsUse(PlayerTotalCountEnchantedItemsUseCondition.class),
    PlayerTotemUseOnBattle(PlayerTotemUseOnBattleCondition.class),
    PlayerUseItemWithRangeDurability(PlayerUseItemWithRangeDurabilityCondition.class),
    PlayerUseSequenceItemOnBattle(PlayerUseSequenceItemOnBattleCondition.class),
    Quest(QuestCondition.class),
    RandomNumber(RandomNumberCondition.class),
    RealDate(RealDateCondition.class),
    RealDay(RealDayCondition.class),
    SpeedKillEntity(SpeedKillEntityCondition.class),
    ToolType(ToolTypeCondition.class),
    Weather(WeatherCondition.class),
    PMMOLevel(PMMOLevelCondition.class),
    ScaleDifficult(ScaleDifficultCondition.class),


    And(AndCondition.class),
    Or(OrCondition.class),
    Not(NotCondition.class);


    @ZenCodeType.Field
    public Class<? extends LootCondition> condition;
    ConditionsList(Class<? extends LootCondition> condition){
        this.condition = condition;
    }
}
