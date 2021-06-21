package me.majorsopa.antidraingang.module.setting;

import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;

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
}