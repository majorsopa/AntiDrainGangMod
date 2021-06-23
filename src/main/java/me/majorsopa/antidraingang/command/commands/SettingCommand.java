package me.majorsopa.antidraingang.command.commands;

import me.majorsopa.antidraingang.AntiDrainGang;
import me.majorsopa.antidraingang.api.util.TextFormatting;
import me.majorsopa.antidraingang.command.Command;
import me.majorsopa.antidraingang.command.CommandManager;
import me.majorsopa.antidraingang.module.Module;
import me.majorsopa.antidraingang.module.ModuleManager;
import me.majorsopa.antidraingang.module.setting.Setting;
import me.majorsopa.antidraingang.module.setting.settings.*;

public class SettingCommand extends Command {
    public SettingCommand() {
        super("setting", "change settings of a module with a command.", "setting <module> <setting> <value>", "s");
    }

    @Override
    public void onCommand(String[] args, String command) {
        if (args.length > 2) {
            boolean moduleFound = false;
            boolean settingFound = false;

            String moduleName = args[0];
            for (Module module : ModuleManager.modules) {
                String moduleIn = module.name;
                moduleIn = moduleIn.replaceAll("\\s", "");
                if(moduleIn.equalsIgnoreCase(moduleName)) {
                    moduleFound = true;
                    break;
                }
            }

            String settingName = args[1];
            for (Setting setting : ModuleManager.getModuleByName(moduleName).settings) {
                String settingIn = setting.name;
                settingIn = settingIn.replaceAll("\\s", "");
                if (settingIn.equalsIgnoreCase(settingName)) {
                    settingFound = true;
                    break;
                }
            }

            String value = args[2];


            Setting settingType = AntiDrainGang.classes.settingManager.getSettingByName(
                    AntiDrainGang.classes.moduleManager.getModule(moduleName),
                    settingName);

            if (settingType instanceof BooleanSetting) {
                try {
                    ((BooleanSetting) settingType).setEnabled(Boolean.parseBoolean(value));
                } catch (Exception ignored) {
                    CommandManager.addChatMessage(TextFormatting.DARK_RED + "Enter either true or false. If you do not know why this is happening, please report it in an issue on the github here " + AntiDrainGang.variables.repo);
                }
            } else if (settingType instanceof ColorSetting) {

            } else if (settingType instanceof KeybindSetting) {

            } else if (settingType instanceof ModeSetting) {

            } else if (settingType instanceof NumberSetting) {
                try {
                    ((NumberSetting) settingType).setValue(Double.parseDouble(value));
                } catch (Exception ignored) {
                    CommandManager.addChatMessage(TextFormatting.DARK_RED + "Something not good happened in the setting command class. Please report it in an issue on the github here " + AntiDrainGang.variables.repo);
                }
            } else {
                CommandManager.addChatMessage(TextFormatting.DARK_RED + "Something not good happened in the setting command class. Please report it in an issue on the github here " + AntiDrainGang.variables.repo);
            }
        } else {
            CommandManager.correctUsageMsg(name, syntax);
        }
    }
}
