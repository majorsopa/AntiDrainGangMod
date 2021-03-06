package me.majorsopa.antidraingang;

import me.majorsopa.antidraingang.api.config.SaveLoad;
import me.majorsopa.antidraingang.api.event.EventProcessor;
import me.majorsopa.antidraingang.command.Command;
import me.majorsopa.antidraingang.command.CommandManager;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;
import me.majorsopa.antidraingang.module.setting.SettingManager;
import me.majorsopa.antidraingang.ui.UI;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * @author SrgantMooMoo
 * @since 5/16/2021
 *
 * THANKS MOOMOO!! -majorsopa
 */

public class AntiDrainGang implements ModInitializer {
	public static AntiDrainGang INSTANCE;
	
	public AntiDrainGang() {
		INSTANCE = this;
	}

	@Override
	public void onInitialize() {
		variables.modid = "antidraingang";
		variables.modname = "AntiDrainGang";
		variables.modversion = "0.0.1";
		variables.repo = "https://github.com/majorsopa/AntiDrainGangMod";

		includes.includeUI = true;

		init();
	}

	public static class variables {
		public static String modid;
		public static String modname;
		public static String modversion;
		public static String repo;
	}
	
	public static class includes {
		public static boolean includeUI;	
	}
	
	public static class classes {
		public static UI ui;
		public static ModuleManager moduleManager;
		public static SettingManager settingManager;
		public static SaveLoad saveLoad;
		public static EventProcessor eventProcessor;
		public static CommandManager commandManager;
	}
	
	public static final Logger LOGGER = LogManager.getLogger("antidraingang");
	public static EventBus EVENTBUS = new EventManager();
	
	public static Object syncronize = new Object();
	public static void printLog(String text) {
		synchronized (syncronize) {
			LOGGER.info(text);
		}
	}
	
	public static void addModule(Module module) {
		ModuleManager.modules.add(module);
	}
	
	public static void addCommand(Command command) {
		CommandManager.commands.add(command);
	}
	
	public static void init() {
		printLog("welcome to antidraingang!");
		printLog("\n" +
                "     __       ____      ____      \n" +
				"    /  \\     |  _ \\    / ___|     \n" +
				"   / /\\ \\    | | | |  / /  _      \n" +
				"  / /__\\ \\   | | | | | |  | |     \n" +
				" / .----. \\  | |_| |  \\ \\_| |     \n" +
				"/_/      \\_\\ |____/    \\____|     \n");
		
		classes.eventProcessor = new EventProcessor();
		printLog("event system initialized.");
		
		classes.commandManager = new CommandManager();
		printLog("command system initialized.");
		
		classes.moduleManager = new ModuleManager();
		printLog("module system initialized.");
		
		classes.settingManager = new SettingManager();
		printLog("setting system initialized.");

		classes.ui = new UI();
		printLog("ui initialized.");
		
		classes.saveLoad = new SaveLoad();
		printLog("config initialized.");
	}

}