package org.techarts.essentialcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.techarts.essentialcore.EssentialCore;
import org.techarts.essentialcore.Managers.HomeManager;
import org.techarts.essentialcore.Utils.Colorize;

public class SetHomeCommand implements CommandExecutor {
    private static final HomeManager homeManager = EssentialCore.getInstance().getHomeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Colorize.sendMessage(sender, "&cTento příkaz mohou provést pouze hráči.");
            return true;
        }
        Player player = (Player) sender;

        homeManager.saveHome(player.getUniqueId(), player.getLocation());
        Colorize.sendMessage(player, "&aNový domov byl nastaven.");

        return false;
    }
}
