# SkeletonsKillByEachOtherEvent

The event is not cancelable.

The event does not have a result.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.events.living.SkeletonsKillByEachOtherEvent;
```


## Extending LivingEvent

SkeletonsKillByEachOtherEvent extends [LivingEvent](/forge/api/event/entity/living/LivingEvent). That means all methods available in [LivingEvent](/forge/api/event/entity/living/LivingEvent) are also available in SkeletonsKillByEachOtherEvent

## Methods

:::group{name=getDead}

Return Type: [LivingEntity](/vanilla/api/entity/LivingEntity)

```zenscript
// SkeletonsKillByEachOtherEvent.getDead() as LivingEntity

mySkeletonsKillByEachOtherEvent.getDead();
```

:::

:::group{name=getKiller}

Return Type: [LivingEntity](/vanilla/api/entity/LivingEntity)

```zenscript
// SkeletonsKillByEachOtherEvent.getKiller() as LivingEntity

mySkeletonsKillByEachOtherEvent.getKiller();
```

:::


