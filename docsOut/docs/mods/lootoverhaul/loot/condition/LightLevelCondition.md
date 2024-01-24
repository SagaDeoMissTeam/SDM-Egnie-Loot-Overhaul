# LightLevelCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.LightLevelCondition;
```


## Extending LootCondition

LightLevelCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in LightLevelCondition

## Constructors


```zenscript
new LightLevelCondition(num as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as LightLevelCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new LightLevelCondition(min as int, max as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as LightLevelCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| min       | int                                                  |
| max       | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// LightLevelCondition.getPriority() as int

myLightLevelCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// LightLevelCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myLightLevelCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
LightLevelCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
LightLevelCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


