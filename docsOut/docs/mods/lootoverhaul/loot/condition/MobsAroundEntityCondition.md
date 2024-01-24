# MobsAroundEntityCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.MobsAroundEntityCondition;
```


## Extending LootCondition

MobsAroundEntityCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in MobsAroundEntityCondition

## Constructors


```zenscript
new MobsAroundEntityCondition(entityType as EntityType, count as int, zone as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as MobsAroundEntityCondition
```
| Parameter  |                         Type                         |
|------------|------------------------------------------------------|
| entityType | [EntityType](/vanilla/api/entity/EntityType)         |
| count      | int                                                  |
| zone       | int                                                  |
| side       | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property   | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// MobsAroundEntityCondition.getPriority() as int

myMobsAroundEntityCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// MobsAroundEntityCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myMobsAroundEntityCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
MobsAroundEntityCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
MobsAroundEntityCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


