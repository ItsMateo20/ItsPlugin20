package com.itsmateo20;

import com.itsmateo20.events.JoinQuit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ItsPlugin20 extends JavaPlugin {
    private static ItsPlugin20 instance;


    @Override
    public void onEnable() {
        instance = this;
        FileConfiguration config = getConfig();
        config.addDefault("Prefix", "[ItsPlugin20]:");
        config.addDefault("JoinQuit", true);
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getLogger().info(config.getString("Prefix") + " Loading config.");
        Bukkit.getLogger().info(config.getString("Prefix") + " Loaded config.");
        if (config.getBoolean("JoinQuit")) {
            Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
        }
        Bukkit.getLogger().info(config.getString("Prefix") + ChatColor.GREEN + " Enabled successfully!");
    }

    @Override
    public void onDisable() {
        FileConfiguration config = getConfig();
        Bukkit.getLogger().info(config.getString("Prefix") + ChatColor.RED + " Disabled successfully!");
    }

    public static ItsPlugin20 getInstance() {
        return instance;
    }
}
