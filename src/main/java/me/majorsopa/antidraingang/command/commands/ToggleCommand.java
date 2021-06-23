package me.majorsopa.antidraingang.command.commands;

import me.majorsopa.antidraingang.api.util.TextFormatting;
import me.majorsopa.antidraingang.command.Command;
import me.majorsopa.antidraingang.command.CommandManager;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;

public class ToggleCommand extends Command {
	
	public ToggleCommand() {
		super("toggle", "toggles a module by name.", "toggle <module>", "t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0]; 
			boolean moduleFound = false;
			for(Module module : ModuleManager.modules) {
				String moduleIn = module.name;
				moduleIn = moduleIn.replaceAll("\\s", "");
				if(moduleIn.equalsIgnoreCase(moduleName)) {
					module.toggle();
					CommandManager.addChatMessage(module.name + " " + (module.isEnabled() ? TextFormatting.GREEN + "enabled" + TextFormatting.GRAY + "." : TextFormatting.DARK_RED + "disabled" + TextFormatting.GRAY + "."));
					moduleFound = true;
					break;
				}
			}
			if(!moduleFound) {
				CommandManager.addChatMessage(TextFormatting.DARK_RED + "module not found.");
			}
		}else {
			CommandManager.correctUsageMsg(name, syntax);
		}
	}

}