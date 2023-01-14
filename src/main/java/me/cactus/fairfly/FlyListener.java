package me.cactus.fairfly;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.cactus.fairfly.Main.removeElytra;

public class FlyListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        // Проверка на отсутствие права на обход
        if (!player.hasPermission("fairfly.bypass")) {

            // Если игрок не летает то ниче не делать
            if (!player.getAllowFlight()) {
                return;
            }

            // Если игрок снял элитры во время полета дать по ебалу
            if (event.getCurrentItem().getType() == Material.ELYTRA && event.getRawSlot() == 6) {
                player.setAllowFlight(false);
                player.sendMessage(removeElytra);
            }
        }
    }
}