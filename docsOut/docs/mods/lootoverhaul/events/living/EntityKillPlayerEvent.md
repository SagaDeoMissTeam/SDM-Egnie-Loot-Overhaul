# EntityKillPlayerEvent

The event is not cancelable.

The event does not have a result.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.events.living.EntityKillPlayerEvent;
```


## Extending LivingEvent

EntityKillPlayerEvent extends [LivingEvent](/forge/api/event/entity/living/LivingEvent). That means all methods available in [LivingEvent](/forge/api/event/entity/living/LivingEvent) are also available in EntityKillPlayerEvent

## Methods

:::group{name=getPlayer}

Return Type: [Player](/vanilla/api/entity/type/player/Player)

```zenscript
// EntityKillPlayerEvent.getPlayer() as Player

myEntityKillPlayerEvent.getPlayer();
```

:::


