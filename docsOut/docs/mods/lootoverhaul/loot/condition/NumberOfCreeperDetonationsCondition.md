# NumberOfCreeperDetonationsCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.NumberOfCreeperDetonationsCondition;
```


## Extending LootCondition

NumberOfCreeperDetonationsCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in NumberOfCreeperDetonationsCondition

## Constructors


```zenscript
new NumberOfCreeperDetonationsCondition(num as int, property as LootProperty) as NumberOfCreeperDetonationsCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new NumberOfCreeperDetonationsCondition(min as int, max as int, property as LootProperty) as NumberOfCreeperDetonationsCondition
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
// NumberOfCreeperDetonationsCondition.getPriority() as int

myNumberOfCreeperDetonationsCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// NumberOfCreeperDetonationsCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myNumberOfCreeperDetonationsCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
NumberOfCreeperDetonationsCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
NumberOfCreeperDetonationsCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


