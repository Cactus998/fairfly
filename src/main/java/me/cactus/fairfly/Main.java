package me.cactus.fairfly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static String noPermission;
    public static String turnOn;
    public static String turnOff;
    public static String noElytra;
    public static String removeElytra;

    @Override
    public void onEnable() {

        // Работа с конфигом
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        noPermission = ChatColor.translateAlternateColorCodes('&', config.getString("no-permission"));
        turnOn = ChatColor.translateAlternateColorCodes('&', config.getString("turn-on"));
        turnOff = ChatColor.translateAlternateColorCodes('&', config.getString("turn-off"));
        noElytra = ChatColor.translateAlternateColorCodes('&', config.getString("no-elytra"));
        removeElytra = ChatColor.translateAlternateColorCodes('&', config.getString("remove-elytra"));

        // Работа с уже летающими игроками
        Bukkit.getPluginManager().registerEvents(new FlyListener(), this);

        // Работа с командой fly
        getCommand("fly").setExecutor(new FlyCommand());
    }
}
