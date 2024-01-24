# EntitySeeSkyCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntitySeeSkyCondition;
```


## Extending LootCondition

EntitySeeSkyCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntitySeeSkyCondition

## Constructors


```zenscript
new EntitySeeSkyCondition(side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntitySeeSkyCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntitySeeSkyCondition.getPriority() as int

myEntitySeeSkyCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntitySeeSkyCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntitySeeSkyCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntitySeeSkyCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntitySeeSkyCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


