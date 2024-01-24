# GameCurrentDayCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.GameCurrentDayCondition;
```


## Extending LootCondition

GameCurrentDayCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in GameCurrentDayCondition

## Constructors


```zenscript
new GameCurrentDayCondition(day as long, property as LootProperty) as GameCurrentDayCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| day       | long                                                 |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// GameCurrentDayCondition.getPriority() as int

myGameCurrentDayCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// GameCurrentDayCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myGameCurrentDayCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
GameCurrentDayCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
GameCurrentDayCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


