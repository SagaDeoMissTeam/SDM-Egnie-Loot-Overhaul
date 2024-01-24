# LootProperty

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.LootProperty;
```


## Constructors


```zenscript
new LootProperty(type as LootType) as LootProperty
```
| Parameter |                            Type                             |
|-----------|-------------------------------------------------------------|
| type      | [LootType](/mods/lootoverhaul/loot/condition/type/LootType) |



```zenscript
new LootProperty(lootConditionList as stdlib.List<LootCondition>, type as LootType) as LootProperty
```
|     Parameter     |                                           Type                                            |
|-------------------|-------------------------------------------------------------------------------------------|
| lootConditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |
| type              | [LootType](/mods/lootoverhaul/loot/condition/type/LootType)                               |



## Methods

:::group{name=add}

Return Type: [LootProperty](/mods/lootoverhaul/loot/LootProperty)

```zenscript
LootProperty.add(lootConditionList as LootCondition) as LootProperty
```

|     Parameter     |                                  Type                                  |
|-------------------|------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) |


:::

:::group{name=add}

Return Type: [LootProperty](/mods/lootoverhaul/loot/LootProperty)

```zenscript
LootProperty.add(lootConditionList as LootCondition[]) as LootProperty
```

|     Parameter     |                                   Type                                   |
|-------------------|--------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)[] |


:::

:::group{name=add}

Return Type: [LootProperty](/mods/lootoverhaul/loot/LootProperty)

```zenscript
LootProperty.add(lootConditionList as stdlib.List<LootCondition>) as LootProperty
```

|     Parameter     |                                           Type                                            |
|-------------------|-------------------------------------------------------------------------------------------|
| lootConditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |


:::

:::group{name=add}

Return Type: [LootProperty](/mods/lootoverhaul/loot/LootProperty)

```zenscript
LootProperty.add(lootResult as ILootResult) as LootProperty
```

| Parameter  |                                Type                                 |
|------------|---------------------------------------------------------------------|
| lootResult | [ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult) |


:::

:::group{name=create}

```zenscript
// LootProperty.create()

myLootProperty.create();
```

:::

:::group{name=saveFile}

Return Type: [LootProperty](/mods/lootoverhaul/loot/LootProperty)

```zenscript
// LootProperty.saveFile() as LootProperty

myLootProperty.saveFile();
```

:::


## Properties

|       Name        |                                           Type                                            | Has Getter | Has Setter |
|-------------------|-------------------------------------------------------------------------------------------|------------|------------|
| id                | string                                                                                    | true       | true       |
| lootConditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; | true       | true       |
| lootResults       | stdlib.List&lt;[ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult)&gt;    | true       | true       |
| type              | [LootType](/mods/lootoverhaul/loot/condition/type/LootType)                               | true       | true       |

