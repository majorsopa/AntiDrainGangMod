package me.majorsopa.antidraingang.module.modules.hud;

import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.setting.settings.NumberSetting;

public class TotemHud extends Module {
    public NumberSetting xCoordSetting = new NumberSetting("xcoord", this, 0, 0, 5000, 100);
    public NumberSetting yCoordSetting = new NumberSetting("ycoord", this, 0, 0, 5000, 100);

    public TotemHud() {
        super("TotemHUD", "Shows how many totems you have left", -1, Module.Category.HUD);

        addSettings(xCoordSetting);
        addSettings(yCoordSetting);
    }
    // the render is located in a mixin, specifically InGameHudMixin.java
}
