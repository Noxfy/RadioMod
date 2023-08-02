package net.noxfy.radio.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.noxfy.radio.item.ModItems;

public class RadioClient implements ClientModInitializer {
    public static boolean render_chat = false;
    public static boolean allow_chat_usage = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            if (client.player != null) {
                allow_chat_usage = render_chat = client.player.getMainHandStack().getItem() == ModItems.RADIO_ITEM || client.player.isCreative() || client.player.isSpectator();
            }
        });
    }
}
