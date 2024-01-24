# ItemResult

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.result.ItemResult;
```


## Extending ILootResult

ItemResult extends [ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult). That means all methods available in [ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult) are also available in ItemResult

## Constructors


```zenscript
new ItemResult(item as ItemStack) as ItemResult
```
| Parameter |                   Type                   |
|-----------|------------------------------------------|
| item      | [ItemStack](/vanilla/api/item/ItemStack) |



## Methods

:::group{name=giveReward}

Return Type: boolean

```zenscript
ItemResult.giveReward(entity as Entity, pos as BlockPos) as boolean
```

| Parameter |                    Type                     |
|-----------|---------------------------------------------|
| entity    | [Entity](/vanilla/api/entity/Entity)        |
| pos       | [BlockPos](/vanilla/api/util/math/BlockPos) |


:::


