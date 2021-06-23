package me.majorsopa.antidraingang.mixins;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.api.util.InventoryUtil;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo callbackInfo) {
        // fps counter render
        if (ModuleManager.isModuleEnabled("FPS Counter")) {
            String fps = String.valueOf(((MinecraftClientMixin) mc).getCurrentFps());

            Module fpsCounter = AntiDrainGang.classes.moduleManager.getModule("FpsCounter");
            int textPosX = (int) AntiDrainGang.classes.settingManager.getNumberSetting(fpsCounter, "xcoord").getValue();
            int textPosY = (int) AntiDrainGang.classes.settingManager.getNumberSetting(fpsCounter, "ycoord").getValue();

            mc.textRenderer.drawWithShadow(matrixStack, fps, textPosX, textPosY, 0xFFFFFF);
        }

        // totem counter render
        if (ModuleManager.isModuleEnabled("TotemHUD")) {
            int totemAmount = InventoryUtil.amountInInv(Items.TOTEM_OF_UNDYING);
            String totems;
            if (totemAmount == 1) {
                totems = "1 totem";
            } else {
                totems = String.format("%d totems", totemAmount);
            }

            Module totemHUD = AntiDrainGang.classes.moduleManager.getModule("TotemHUD");
            int textPosX = (int) AntiDrainGang.classes.settingManager.getNumberSetting(totemHUD, "xcoord").getValue();
            int textPosY = (int) AntiDrainGang.classes.settingManager.getNumberSetting(totemHUD, "ycoord").getValue();

            if (totemAmount <= 2) {
                mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF0000);
            } else if (totemAmount == 3 || totemAmount == 4) {
                mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF6347);
            } else {
                mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0x00D100);
            }
        }
    }
}
