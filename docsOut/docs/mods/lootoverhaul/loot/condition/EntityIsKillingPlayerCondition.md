# EntityIsKillingPlayerCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityIsKillingPlayerCondition;
```


## Extending LootCondition

EntityIsKillingPlayerCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityIsKillingPlayerCondition

## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityIsKillingPlayerCondition.getPriority() as int

myEntityIsKillingPlayerCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityIsKillingPlayerCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityIsKillingPlayerCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityIsKillingPlayerCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityIsKillingPlayerCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


