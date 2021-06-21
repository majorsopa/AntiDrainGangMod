package me.majorsopa.antidraingang.mixins;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.api.config.SaveLoad;
import me.majorsopa.antidraingang.api.util.InventoryUtil;
import me.majorsopa.antidraingang.module.ModuleManager;
import me.majorsopa.antidraingang.module.modules.TotemHud;
import me.majorsopa.antidraingang.module.setting.Setting;
import me.majorsopa.antidraingang.module.setting.SettingManager;
import me.majorsopa.antidraingang.module.setting.settings.NumberSetting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(InGameHud.class)
public abstract class TotemRenderMixin {
    MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo callbackInfo) {
        int totemAmount = InventoryUtil.amountInInv(Items.TOTEM_OF_UNDYING);
        String totems;
        if (totemAmount == 1) {
            totems = "1 totem";
        } else {
            totems = String.format("%d totems", totemAmount);
        }

        List<Setting> totemSettings = AntiDrainGang.classes.moduleManager.getModule("TotemHUD").settings;

        int textPosX = 0;
        int textPosY = 0;

        for (int i = 0; i < totemSettings.size(); i++) {
            Setting saidSetting = totemSettings.get(i);
            if (saidSetting instanceof NumberSetting) {
                if (saidSetting.name == "X Coordinate") {
                    textPosX = (int) ((NumberSetting) saidSetting).value;
                } else if (saidSetting.name == "Y Coordinate") {
                    textPosY = (int) ((NumberSetting) saidSetting).value;
                }
            }
        }

        if (totemAmount <= 0) {
            mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF0000);
        } else if (totemAmount == 1) {
            mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF0000);
        } else if (totemAmount == 2) {
            mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF0000);
        } else if (totemAmount == 3 || totemAmount == 4) {
            mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0xFF6347);
        } else {
            mc.textRenderer.drawWithShadow(matrixStack, totems, textPosX, textPosY, 0x00D100);
        }
    }
}
