# LootBlockType

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.type.LootBlockType;
```


## Extending LootType

LootBlockType extends [LootType](/mods/lootoverhaul/loot/condition/type/LootType). That means all methods available in [LootType](/mods/lootoverhaul/loot/condition/type/LootType) are also available in LootBlockType

## Constructors


```zenscript
new LootBlockType(block as Block) as LootBlockType
```
| Parameter |               Type                |
|-----------|-----------------------------------|
| block     | [Block](/vanilla/api/block/Block) |



## Methods

:::group{name=getLootTables}

Return Type: stdlib.List&lt;[ResourceLocation](/vanilla/api/resource/ResourceLocation)&gt;

```zenscript
// LootBlockType.getLootTables() as stdlib.List<ResourceLocation>

myLootBlockType.getLootTables();
```

:::


