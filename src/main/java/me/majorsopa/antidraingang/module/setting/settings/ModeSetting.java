package me.majorsopa.antidraingang.module.setting.settings;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.setting.Setting;

import java.util.Arrays;
import java.util.List;

/** the first mode is the default mode, it has to be declared already as one of the following modes, you can have as many modes as you'd like.
 * @author SrgantMooMoo
 * @since 05/16/2021
 */

public class ModeSetting extends Setting {
	public int index;
	  
	public List<String> modes;
	  
	public ModeSetting(String name, Module parent, String defaultMode, String... modes) {
	    this.name = name;
	    this.parent = parent;
	    this.modes = Arrays.asList(modes);
	    this.index = this.modes.indexOf(defaultMode);
	}
	  
	public String getMode() {
	    return this.modes.get(this.index);
	}
	  
	public void setMode(String mode) {
		  this.index = this.modes.indexOf(mode);
		  
		  if(AntiDrainGang.classes.saveLoad != null) {
				AntiDrainGang.classes.saveLoad.save();
		    }
	}
	  
	public boolean is(String mode) {
	    return (this.index == this.modes.indexOf(mode));
	}
	  
	public void cycle() {
	    if (this.index < this.modes.size() - 1) {
	      this.index++;
	    } else {
	      this.index = 0;
	    }
	}
}