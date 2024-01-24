# CountCurrentBlockAroundEntityCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.CountCurrentBlockAroundEntityCondition;
```


## Extending LootCondition

CountCurrentBlockAroundEntityCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in CountCurrentBlockAroundEntityCondition

## Constructors


```zenscript
new CountCurrentBlockAroundEntityCondition(block as Block, count as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as CountCurrentBlockAroundEntityCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| block     | [Block](/vanilla/api/block/Block)                    |
| count     | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new CountCurrentBlockAroundEntityCondition(block as Block, count as int, zone as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as CountCurrentBlockAroundEntityCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| block     | [Block](/vanilla/api/block/Block)                    |
| count     | int                                                  |
| zone      | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// CountCurrentBlockAroundEntityCondition.getPriority() as int

myCountCurrentBlockAroundEntityCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// CountCurrentBlockAroundEntityCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myCountCurrentBlockAroundEntityCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
CountCurrentBlockAroundEntityCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
CountCurrentBlockAroundEntityCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


