package me.cactus.fairfly;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.cactus.fairfly.Main.*;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Проверка на гениальность создателя сервера
        if (!(sender instanceof Player)) {
            sender.sendMessage("Эта команда не для консоли.");
            return true;
        }

        Player player = (Player) sender;

        // Проверка на право игрока
        if (!player.hasPermission("fairfly.use")) {
            player.sendMessage(noPermission);
            return true;
        }

        // Проверка на надетые элитры
        ItemStack chestplate = player.getInventory().getChestplate();
        if (chestplate == null || chestplate.getType() != Material.ELYTRA) {
            player.sendMessage(noElytra);
            return true;
        }

        // Логика работы
        player.setAllowFlight(!player.getAllowFlight());
        if (player.getAllowFlight()) {
            player.sendMessage(turnOn);
        } else {
            player.sendMessage(turnOff);
        }
        return true;
    }
}
