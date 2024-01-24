# PlayerTotemUseOnBattleCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerTotemUseOnBattleCondition;
```


## Extending LootCondition

PlayerTotemUseOnBattleCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerTotemUseOnBattleCondition

## Constructors


```zenscript
new PlayerTotemUseOnBattleCondition(num as int, property as LootProperty) as PlayerTotemUseOnBattleCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerTotemUseOnBattleCondition(min as int, max as int, property as LootProperty) as PlayerTotemUseOnBattleCondition
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
// PlayerTotemUseOnBattleCondition.getPriority() as int

myPlayerTotemUseOnBattleCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerTotemUseOnBattleCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerTotemUseOnBattleCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerTotemUseOnBattleCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerTotemUseOnBattleCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


