package org.techarts.essentialcore.Commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.techarts.essentialcore.EssentialCore;
import org.techarts.essentialcore.Managers.HomeManager;
import org.techarts.essentialcore.Utils.Colorize;

public class HomeCommand implements CommandExecutor {
    private static final HomeManager homeManager = EssentialCore.getInstance().getHomeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Colorize.sendMessage(sender, "&cTento příkaz mohou provést pouze hráči.");
            return true;
        }
        Player player = (Player) sender;
        final Location home = homeManager.getHome(player.getUniqueId());

        if (home == null) {
            Colorize.sendMessage(player, "&cNemáš nastavený domov.");
            return true;
        }

        if (!player.getInventory().contains(Material.DIAMOND)) {
            Colorize.sendMessage(player, "&cNemáš diamant pro teleportaci.");
            return true;
        }

        player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
        player.teleport(home);
        Colorize.sendMessage(player, "&aByl jsi teleportován domů.");
        return true;
    }
}
