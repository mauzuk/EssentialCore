package org.techarts.essentialcore.Managers;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.techarts.essentialcore.EssentialCore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeManager {
    private final Map<UUID, Location> homesCache = new HashMap<>();
    private final FileConfiguration config;

    public HomeManager(FileConfiguration config) {
        this.config = config;
    }

    public void saveHome(UUID player, Location home) {
        this.homesCache.put(player, home);
        config.set("homes." + player.toString(), home);
        EssentialCore.getInstance().saveConfig();
    }

    public Location getHome(UUID player) {
        if (!homesCache.containsKey(player)) {
            homesCache.put(player, config.getLocation("homes." + player.toString()));
        }
        return homesCache.get(player);
    }
}
