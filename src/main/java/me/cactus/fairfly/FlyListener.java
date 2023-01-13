package me.cactus.fairfly;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import static me.cactus.fairfly.Main.removeElytra;

public class FlyListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Если игрок не летает то ниче не делать
        if (!player.getAllowFlight()) {
            return;
        }

        // Если игрок летает то чекнуть надеты ли элитры если нет дать по ебалу
        ItemStack chestplate = player.getInventory().getChestplate();
        if (chestplate == null || chestplate.getType() != Material.ELYTRA) {
            player.setAllowFlight(false);
            player.sendMessage(removeElytra);
        }
    }
}




