# CustomConditionEvent

The event is not cancelable.

The event does not have a result.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.events.living.CustomConditionEvent;
```


## Extending Event

CustomConditionEvent extends [Event](/forge/api/event/Event). That means all methods available in [Event](/forge/api/event/Event) are also available in CustomConditionEvent

## Methods

:::group{name=getBlockEntity}

Return Type: [BlockEntity](/vanilla/api/block/entity/BlockEntity)

```zenscript
// CustomConditionEvent.getBlockEntity() as BlockEntity

myCustomConditionEvent.getBlockEntity();
```

:::

:::group{name=getEntity}

Return Type: [Entity](/vanilla/api/entity/Entity)

```zenscript
// CustomConditionEvent.getEntity() as Entity

myCustomConditionEvent.getEntity();
```

:::

:::group{name=getEntityKilled}

Return Type: [Entity](/vanilla/api/entity/Entity)

```zenscript
// CustomConditionEvent.getEntityKilled() as Entity

myCustomConditionEvent.getEntityKilled();
```

:::

:::group{name=getId}

Return Type: string

```zenscript
// CustomConditionEvent.getId() as string

myCustomConditionEvent.getId();
```

:::

:::group{name=getLevel}

Return Type: [Level](/vanilla/api/world/Level)

```zenscript
// CustomConditionEvent.getLevel() as Level

myCustomConditionEvent.getLevel();
```

:::

:::group{name=getPos}

Return Type: [BlockPos](/vanilla/api/util/math/BlockPos)

```zenscript
// CustomConditionEvent.getPos() as BlockPos

myCustomConditionEvent.getPos();
```

:::

:::group{name=getType}

Return Type: [LootType](/mods/lootoverhaul/loot/condition/type/LootType)

```zenscript
// CustomConditionEvent.getType() as LootType

myCustomConditionEvent.getType();
```

:::

:::group{name=setResult}

```zenscript
CustomConditionEvent.setResult(result as boolean)
```

| Parameter |  Type   |
|-----------|---------|
| result    | boolean |


:::


## Properties

|     Name     |                         Type                         | Has Getter | Has Setter |
|--------------|------------------------------------------------------|------------|------------|
| blockEntity  | [BlockEntity](/vanilla/api/block/entity/BlockEntity) | true       | false      |
| entity       | [Entity](/vanilla/api/entity/Entity)                 | true       | false      |
| entityKilled | [Entity](/vanilla/api/entity/Entity)                 | true       | false      |
| id           | string                                               | true       | false      |
| level        | [Level](/vanilla/api/world/Level)                    | true       | false      |
| pos          | [BlockPos](/vanilla/api/util/math/BlockPos)          | true       | false      |

