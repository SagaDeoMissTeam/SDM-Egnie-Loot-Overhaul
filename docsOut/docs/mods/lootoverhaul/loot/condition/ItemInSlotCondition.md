# ItemInSlotCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.ItemInSlotCondition;
```


## Extending LootCondition

ItemInSlotCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in ItemInSlotCondition

## Constructors


```zenscript
new ItemInSlotCondition(stack as ItemStack, slot as int, property as LootProperty) as ItemInSlotCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| stack     | [ItemStack](/vanilla/api/item/ItemStack)             |
| slot      | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// ItemInSlotCondition.getPriority() as int

myItemInSlotCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// ItemInSlotCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myItemInSlotCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
ItemInSlotCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
ItemInSlotCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


