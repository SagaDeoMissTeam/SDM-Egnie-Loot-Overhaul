# PlayerEntityKillCountCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerEntityKillCountCondition;
```


## Extending LootCondition

PlayerEntityKillCountCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerEntityKillCountCondition

## Constructors


```zenscript
new PlayerEntityKillCountCondition(entityType as EntityType, count as int, property as LootProperty) as PlayerEntityKillCountCondition
```
| Parameter  |                         Type                         |
|------------|------------------------------------------------------|
| entityType | [EntityType](/vanilla/api/entity/EntityType)         |
| count      | int                                                  |
| property   | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerEntityKillCountCondition.getPriority() as int

myPlayerEntityKillCountCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerEntityKillCountCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerEntityKillCountCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerEntityKillCountCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerEntityKillCountCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


