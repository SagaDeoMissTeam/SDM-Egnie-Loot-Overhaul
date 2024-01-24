# PlayerDeadCountCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerDeadCountCondition;
```


## Extending LootCondition

PlayerDeadCountCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerDeadCountCondition

## Constructors


```zenscript
new PlayerDeadCountCondition(num as int, property as LootProperty) as PlayerDeadCountCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerDeadCountCondition(min as int, max as int, property as LootProperty) as PlayerDeadCountCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| min       | int                                                  |
| max       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerDeadCountCondition.getPriority() as int

myPlayerDeadCountCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerDeadCountCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerDeadCountCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerDeadCountCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerDeadCountCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


