# Velox Example Plugin (Swear Bonk)
![Bonk](https://github.com/mikex86/VeloxExamplePlugin/blob/master/images/bonk.jpg)


A small plugin to demonstrate functionality of the (more than incomplete) Velox Plugin API.

```java
public class SwearBonk implements JvmPlugin {

    @Override
    public void initListeners(@NotNull EventListenerRegistry registry) {
        registry.registerListener(this::onChatEvent, PlayerChatEvent.class);
    }

    private void onChatEvent(@NotNull PlayerChatEvent event) {
        String message = event.getMessage();
        EntityThreadGuard<ServerPlayerEntity> sender = event.getSender();
        if (message.toLowerCase().contains("fuck")) {
            GameTick.runEntityTickTaskInRegion(sender, () -> {
                ServerPlayerEntity playerEntity = sender.getValue();
                playerEntity.hurt(DamageSource.GENERIC, 1);
            });
        }
    }

}
```