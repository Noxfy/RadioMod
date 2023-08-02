package net.noxfy.radio.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import net.noxfy.radio.client.RadioClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    @Inject(method = "isChatHidden", at = @At("RETURN"), cancellable = true)
    protected void stopRender(CallbackInfoReturnable<Boolean> cir) {
        if (!RadioClient.render_chat) {
            cir.setReturnValue(true);
        }
    }
}
