package me.majorsopa.antidraingang.module.modules;

import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.setting.settings.NumberSetting;

public class TotemHud extends Module {
    public NumberSetting xCoordSetting = new NumberSetting("X Coordinate", this, 0, 0, 5000, 100);
    public NumberSetting yCoordSetting = new NumberSetting("Y Coordinate", this, 0, 0, 5000, 100);

    public TotemHud(String name, String description, int key, Category category) {
        super(name, description, key, category);

        addSettings(xCoordSetting);
        addSettings(yCoordSetting);
    }
    // the render is located in a mixin, specifically TotemRenderMixin.java
}
