package me.majorsopa.antidraingang.ui;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.api.event.events.EventDrawOverlay;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

import java.util.Comparator;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class UI {
	private MinecraftClient mc = MinecraftClient.getInstance();

	public UI() {
		if(AntiDrainGang.includes.includeUI) AntiDrainGang.EVENTBUS.subscribe(listener);
	}
	
	@EventHandler
	private final Listener<EventDrawOverlay> listener = new Listener<>(e -> {
		TextRenderer tr = mc.textRenderer;
		tr.drawWithShadow(e.matrix, AntiDrainGang.variables.modname + " " + AntiDrainGang.variables.modversion, 2, 2, 0xffffffff);
		
		int y = 1;
		final int[] counter = { 1 };
		for (Module module : ModuleManager.getModules()) {
			if (module.isEnabled()) {
					tr.drawWithShadow(e.matrix, module.getName(), 2, 10 + y, 0x80808080);
				y += tr.fontHeight;
				counter[0]++;
			}
		}
		ModuleManager.modules.sort(Comparator.comparing(module -> -mc.textRenderer.getWidth(module.getName())));
	});

}