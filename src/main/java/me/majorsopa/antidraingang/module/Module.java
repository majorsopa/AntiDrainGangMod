package me.majorsopa.antidraingang.module;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.module.setting.Setting;
import me.majorsopa.antidraingang.module.setting.settings.KeybindSetting;
import me.zero.alpine.listener.Listenable;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class Module implements Listenable {
	
	protected static final MinecraftClient mc = MinecraftClient.getInstance();
	public static ArrayList<Module> modules;
	
	public String name, description;
	public KeybindSetting keyCode = new KeybindSetting(0);
	public Category category;
	public boolean enabled;
	public int index;
	public List<Setting> settings = new ArrayList<>();
	
	public Module(String name, String description, int key, Category category) {
		super();
		this.name = name;
		this.description = description;
		keyCode.code = key;
		addSettings(keyCode);
		this.category = category;
		enabled = false;
	}
	
	public enum Category {
		HUD("hud"), RENDER("render"), CLIENT("client"), MISCELLANEOUS("miscellaneous");
		public String name;
		public int moduleIndex;
		
		Category(String name) {
			this.name = name;
		}
	}
	
	public void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
		this.settings.sort(Comparator.comparingInt(s -> s == keyCode ? 1 : 0));
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getKey() {
		return keyCode.code;
	}
	
	public void setKey(int key) {
		this.keyCode.code = key;
		
		 if(AntiDrainGang.classes.saveLoad != null) {
				AntiDrainGang.classes.saveLoad.save();
		 }
	} 
	
	public void toggle() {
		enabled = !enabled;
		if(enabled) {
			enable();
		}else {
			disable();
		}
		
		if(AntiDrainGang.classes.saveLoad != null) {
			AntiDrainGang.classes.saveLoad.save();
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			AntiDrainGang.EVENTBUS.subscribe(this);
		}else {
			AntiDrainGang.EVENTBUS.unsubscribe(this);
		}
		
		if(AntiDrainGang.classes.saveLoad != null) {
			AntiDrainGang.classes.saveLoad.save();
		}
	}
	
	public void enable() {
		onEnable();
		setEnabled(true);
	}

	public void disable() {
		onDisable();
		setEnabled(false);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onUpdate() {
		
	}

}
