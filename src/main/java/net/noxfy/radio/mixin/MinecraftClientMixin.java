package net.noxfy.radio.mixin;

import net.minecraft.client.MinecraftClient;
import net.noxfy.radio.client.RadioClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "openChatScreen", at = @At("HEAD"), cancellable = true)
    protected void stopChat(String text, CallbackInfo ci) {
        if (!RadioClient.allow_chat_usage) {
            ci.cancel();
        }
    }
}
