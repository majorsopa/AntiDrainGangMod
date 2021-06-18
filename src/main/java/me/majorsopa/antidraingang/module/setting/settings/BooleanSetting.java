package me.majorsopa.antidraingang.module.setting.settings;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.setting.Setting;

/** the only value you need to worry about is the default value, it can either be true or false.
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class BooleanSetting extends Setting {
	public boolean enabled;
	  
	public BooleanSetting(String name, Module parent, boolean enabled) {
	    this.name = name;
	    this.parent = parent;
	    this.enabled = enabled;
	}
	  
	public boolean isEnabled() {
	    return this.enabled;
	}
	  
	public void setEnabled(boolean enabled) {
	    this.enabled = enabled;
	    
	    if(AntiDrainGang.classes.saveLoad != null) {
			AntiDrainGang.classes.saveLoad.save();
	    }
	}
	
	public void toggle() {
	    this.enabled = !this.enabled;
	    
	    if(AntiDrainGang.classes.saveLoad != null) {
			AntiDrainGang.classes.saveLoad.save();
	    }
	}
}
