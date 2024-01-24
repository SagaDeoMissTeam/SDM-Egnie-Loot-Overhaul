# RealDayCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.RealDayCondition;
```


## Extending LootCondition

RealDayCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in RealDayCondition

## Constructors


```zenscript
new RealDayCondition(day as int, property as LootProperty) as RealDayCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| day       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// RealDayCondition.getPriority() as int

myRealDayCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// RealDayCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myRealDayCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
RealDayCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
RealDayCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


