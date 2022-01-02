package TeamStrati.LobbySystem.listener;

import TeamStrati.LobbySystem.Nubsnils.CMD_Build;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;

public class CancelInventorySwapEvent implements Listener {


    @EventHandler
    public void oninventoryclick(final InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (CMD_Build.build.contains(player)) {
            try {


                Inventory inventory = event.getInventory();

                if (inventory != null) {

                    if (event.getCurrentItem().getType() == Material.FISHING_ROD) {
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getType() == Material.CHEST) {
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getType() == Material.TNT) {
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getType() == Material.COMPASS) {
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getType() == Material.LIME_DYE) {
                        event.setCancelled(true);
                    } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                        event.setCancelled(true);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (NullPointerException ex) {
            }
        }
    }

    @EventHandler
    public void onItemSwap(final PlayerSwapHandItemsEvent e) {

        e.setCancelled(true);
    }


}
