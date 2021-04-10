package org.example.veloxplugin;

import me.mikex86.veloxapi.event.EventListenerRegistry;
import me.mikex86.veloxapi.event.impl.PlayerChatEvent;
import me.mikex86.veloxapi.game.GameTick;
import me.mikex86.veloxapi.plugin.JvmPlugin;
import me.mikex86.veloxapi.threading.EntityThreadGuard;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import org.jetbrains.annotations.NotNull;

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
