# EntityHasEffectCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityHasEffectCondition;
```


## Extending LootCondition

EntityHasEffectCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityHasEffectCondition

## Constructors


```zenscript
new EntityHasEffectCondition(effects as MobEffect, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityHasEffectCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| effects   | [MobEffect](/vanilla/api/entity/effect/MobEffect)    |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityHasEffectCondition.getPriority() as int

myEntityHasEffectCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityHasEffectCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityHasEffectCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityHasEffectCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityHasEffectCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


