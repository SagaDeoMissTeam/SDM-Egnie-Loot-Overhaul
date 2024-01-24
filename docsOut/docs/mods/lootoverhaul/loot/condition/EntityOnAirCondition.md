# EntityOnAirCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityOnAirCondition;
```


## Extending LootCondition

EntityOnAirCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityOnAirCondition

## Constructors


```zenscript
new EntityOnAirCondition(side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityOnAirCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityOnAirCondition.getPriority() as int

myEntityOnAirCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityOnAirCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityOnAirCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityOnAirCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityOnAirCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


