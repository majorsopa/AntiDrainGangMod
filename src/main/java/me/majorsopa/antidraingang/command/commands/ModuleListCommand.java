package me.majorsopa.antidraingang.command.commands;

import me.majorsopa.antidraingang.api.util.TextFormatting;
import me.majorsopa.antidraingang.command.Command;
import me.majorsopa.antidraingang.command.CommandManager;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;

public class ModuleListCommand extends Command {
	
	public ModuleListCommand() {
		super("modulelist", "gets a list of all the modules.", "moduleList", "ml");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 0) {
			for(Module module : ModuleManager.getModules()) {
				CommandManager.addChatMessage(TextFormatting.WHITE + module.getCategory().name + ": " + TextFormatting.GRAY + module.getName());
			}
		} if(args.length > 0) CommandManager.correctUsageMsg(name, syntax);
	}
}