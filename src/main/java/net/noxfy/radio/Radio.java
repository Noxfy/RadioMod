package net.noxfy.radio;

import net.fabricmc.api.ModInitializer;
import net.noxfy.radio.item.ModItems;

public class Radio implements ModInitializer {
    public static final String MOD_ID = "radio";
    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}
