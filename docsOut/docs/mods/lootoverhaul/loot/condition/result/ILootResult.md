# ILootResult

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.result.ILootResult;
```


## Constructors


```zenscript
new ILootResult() as ILootResult
new ILootResult();
```

## Methods

:::group{name=getType}

Return Type: [LootResultList](/mods/lootoverhaul/loot/condition/result/LootResultList)

```zenscript
// ILootResult.getType() as LootResultList

myILootResult.getType();
```

:::

:::group{name=giveReward}

Return Type: boolean

```zenscript
ILootResult.giveReward(entity as Entity, pos as BlockPos) as boolean
```

| Parameter |                    Type                     |
|-----------|---------------------------------------------|
| entity    | [Entity](/vanilla/api/entity/Entity)        |
| pos       | [BlockPos](/vanilla/api/util/math/BlockPos) |


:::


