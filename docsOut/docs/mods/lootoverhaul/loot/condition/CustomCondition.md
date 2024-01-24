# CustomCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.CustomCondition;
```


## Extending LootCondition

CustomCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in CustomCondition

## Constructors


```zenscript
new CustomCondition() as CustomCondition
new CustomCondition();
```

```zenscript
new CustomCondition(id as string, entity as Entity, entityKilled as Entity, pos as BlockPos, level as Level, blockEntity as BlockEntity, property as LootProperty) as CustomCondition
```
|  Parameter   |                         Type                         |
|--------------|------------------------------------------------------|
| id           | string                                               |
| entity       | [Entity](/vanilla/api/entity/Entity)                 |
| entityKilled | [Entity](/vanilla/api/entity/Entity)                 |
| pos          | [BlockPos](/vanilla/api/util/math/BlockPos)          |
| level        | [Level](/vanilla/api/world/Level)                    |
| blockEntity  | [BlockEntity](/vanilla/api/block/entity/BlockEntity) |
| property     | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// CustomCondition.getPriority() as int

myCustomCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// CustomCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myCustomCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
CustomCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
CustomCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


## Properties

|     Name     |                         Type                         | Has Getter | Has Setter |
|--------------|------------------------------------------------------|------------|------------|
| blockEntity  | [BlockEntity](/vanilla/api/block/entity/BlockEntity) | true       | true       |
| entity       | [Entity](/vanilla/api/entity/Entity)                 | true       | true       |
| entityKilled | [Entity](/vanilla/api/entity/Entity)                 | true       | true       |
| id           | string                                               | true       | true       |
| level        | [Level](/vanilla/api/world/Level)                    | true       | true       |
| pos          | [BlockPos](/vanilla/api/util/math/BlockPos)          | true       | true       |

