package org.techarts.essentialcore.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Colorize {
    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(format(message));
    }
}
