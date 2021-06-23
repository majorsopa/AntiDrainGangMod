package me.majorsopa.antidraingang.command.commands;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.api.util.TextFormatting;
import me.majorsopa.antidraingang.command.Command;
import me.majorsopa.antidraingang.command.CommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

@SuppressWarnings("resource")
public class HelpCommand extends Command {
	
	public HelpCommand() {
		super("help", "figure it out.", "help", "h");
	}


	@Override
	public void onCommand(String[] args, String command) {
		welcomeMessage();
		for (Command leCommand : CommandManager.commands) {
			helpMessage(leCommand.getName(), leCommand.getDescription(), leCommand.getSyntax());
		}
		goodbyeMessage();
	}
	
	private void helpMessage(String commandName, String commandDesc, String commandSyntax) {
		String starter = TextFormatting.LIGHT_PURPLE + commandName + TextFormatting.GRAY + " - " + commandDesc;
		String syntaxMessage = " [" + CommandManager.prefix + commandSyntax + "]";

		Text textComponentString = new LiteralText(starter);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(textComponentString);
		Text syntaxTextComponentString = new LiteralText(syntaxMessage);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(syntaxTextComponentString);
	}
	
	private void welcomeMessage() {
		String welcomeString = TextFormatting.GRAY + "" + TextFormatting.BOLD + AntiDrainGang.variables.modname + " " + AntiDrainGang.variables.modversion + "!";
		String bedroom = TextFormatting.AQUA + "@" + TextFormatting.ITALIC + AntiDrainGang.variables.modname;
		String nothing = " ";
		
		Text textComponentString = new LiteralText(welcomeString);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(textComponentString);
		Text nothingTextComponentString = new LiteralText(nothing);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(nothingTextComponentString);
		Text bedroomTextComponentString = new LiteralText(bedroom);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(bedroomTextComponentString);
		
	}
	
	private void goodbyeMessage() {
		String uwu = TextFormatting.GRAY + "" + TextFormatting.BOLD + "uwu" + TextFormatting.AQUA + " ~";
		String nothing = " ";
				
		Text nothingTextComponentString = new LiteralText(nothing);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(nothingTextComponentString);
		Text textComponentString = new LiteralText(uwu);
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(textComponentString);
	}

}