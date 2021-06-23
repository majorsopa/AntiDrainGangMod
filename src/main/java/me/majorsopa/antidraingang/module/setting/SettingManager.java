package me.majorsopa.antidraingang.module.setting;

import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;
import me.majorsopa.antidraingang.module.setting.settings.BooleanSetting;
import me.majorsopa.antidraingang.module.setting.settings.NumberSetting;

import java.util.ArrayList;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class SettingManager {
	
	private ArrayList<Setting> settings;
	
	public SettingManager(){
		this.settings = new ArrayList<>();
	}
	
	public void rSetting(Setting in){
		this.settings.add(in);
	}
	
	public ArrayList<Setting> getSettings() {
		return this.settings;
	}
	
	public ArrayList<Setting> getSettingsByMod(Module mod) {
		ArrayList<Setting> out = new ArrayList<Setting>();
		for(Setting s : getSettings()) {
			if(s.parent.equals(mod)) {
				out.add(s);
			}
		}
		if(out.isEmpty()) {
			return null;
		}
		return out;
	}
	
	public Setting getSettingByName(Module mod, String name) {
		for (Module m : ModuleManager.modules) {
		for (Setting set : m.settings) {
			if (set.name.equalsIgnoreCase(name) && set.parent == mod) {
				return set;
			}
			}
		}
		System.err.println("[AntiDrainGang] Error Setting NOT found: '" + name +"'!");
		return null;
	}

	public BooleanSetting getBooleanSetting(Module module, String name) {
		// if there are no settings of the type it will return null
		for (int i = 0; i < module.settings.size(); i++) {
			Setting inSetting = module.settings.get(i);
			if (inSetting.name.equalsIgnoreCase(name) && inSetting instanceof BooleanSetting) {
				return (BooleanSetting) inSetting;
			}
		}
		return null;
	}

	//todo add the other settings

	public NumberSetting getNumberSetting(Module module, String name) {
		// if there are no settings of the type it will return null
		for (int i = 0; i < module.settings.size(); i++) {
			Setting inSetting = module.settings.get(i);
			if (inSetting.name.equalsIgnoreCase(name) && inSetting instanceof NumberSetting) {
				return (NumberSetting) inSetting;
			}
		}
		return null;
	}
}