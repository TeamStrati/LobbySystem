package TeamStrati.LobbySystem.Nubsnils;

import TeamStrati.LobbySystem.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;


public class Listeners implements Listener {

    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (!CMD_Build.build.contains(p)) {
            p.sendMessage(Main.prefix + "§cDu darfst in der Lobby keine Bl\u00f6cke abbauen");
            e.setCancelled(true);
        }
        else if (CMD_Build.build.contains(p)) {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (CMD_Build.build.contains(p)) {
            e.setCancelled(false);
        }
        else {
            p.sendMessage(Main.prefix + "§cDu darfst in der Lobby keine Bl\u00f6cke platzieren");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        final Player p = e.getPlayer();
        if (!CMD_Build.build.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (!CMD_Build.build.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFood(final FoodLevelChangeEvent e) {

            e.setCancelled(true);

    }

    @EventHandler
    public void onBreak(final EntityDamageEvent e) {
        e.setCancelled(true);
    }

}
