package lobby_shop.LobbyShop.commands.ItemManager;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;


public class ItemEvents implements Listener {


    private File config = new File("plugins//LobbyShop//config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    @EventHandler
    public void inFish(final PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        if (name.equals("§9Grappling Hook")) {

            Integer CoolDown = yamlConfiguration.getInt(("Grappling Hook Cooldown"));


            if (event.getState().equals(PlayerFishEvent.State.REEL_IN) || event.getState().equals(PlayerFishEvent.State.IN_GROUND)) {

                Location playerLocation = player.getLocation();
                Location hookLocation = event.getHook().getLocation();
                Location change = hookLocation.subtract(playerLocation);
                player.setVelocity(change.toVector().multiply(0.4));
                player.setCooldown(Material.FISHING_ROD, CoolDown);


            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onPlace(final PlayerInteractEvent event) {
        if (event.getAction() != null) {
            if (event.getItem() != null) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Player player = event.getPlayer();
                    ItemStack item = player.getInventory().getItemInMainHand();
                    ItemMeta meta = item.getItemMeta();
                    String name = meta.getDisplayName();
                    if (name.equals("§9Effekte und Trails")) {
                        player.performCommand("effects");
                    }
                } else {
                    return;
                }
            }
        }


    }
}

