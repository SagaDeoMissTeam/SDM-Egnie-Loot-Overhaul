# PlayerFoodCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerFoodCondition;
```


## Extending LootCondition

PlayerFoodCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerFoodCondition

## Constructors


```zenscript
new PlayerFoodCondition(num as int, property as LootProperty) as PlayerFoodCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerFoodCondition(min as int, max as int, property as LootProperty) as PlayerFoodCondition
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
// PlayerFoodCondition.getPriority() as int

myPlayerFoodCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerFoodCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerFoodCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerFoodCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerFoodCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


