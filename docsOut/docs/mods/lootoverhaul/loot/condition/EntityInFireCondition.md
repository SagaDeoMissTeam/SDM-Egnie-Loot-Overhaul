# EntityInFireCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityInFireCondition;
```


## Extending LootCondition

EntityInFireCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityInFireCondition

## Constructors


```zenscript
new EntityInFireCondition(side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityInFireCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityInFireCondition.getPriority() as int

myEntityInFireCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityInFireCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityInFireCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityInFireCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityInFireCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


