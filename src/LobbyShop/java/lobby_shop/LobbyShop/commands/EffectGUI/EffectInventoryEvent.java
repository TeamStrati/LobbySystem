package lobby_shop.LobbyShop.commands.EffectGUI;

import lobby_shop.LobbyShop.Main;
import lobby_shop.LobbyShop.trails.Effects;
import lobby_shop.LobbyShop.trails.ParticleData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.io.File;

import static lobby_shop.LobbyShop.Main.prefix;



public class EffectInventoryEvent implements Listener {

    Main plugin;

    String UUID;

    private File config = new File("plugins//LobbyShop//config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    public EffectInventoryEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(final InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        try {


            Inventory inventory = e.getInventory();

            if (inventory != null) {
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "Effekte und Trails")) {
                    e.setCancelled(true);
                    //Shop Menü

                    if (e.getView().getType() == InventoryType.PLAYER)
                        return;

                    ParticleData particle = new ParticleData(player.getUniqueId());

                    if (particle.hasID()) {
                        particle.endTask();
                        particle.removeID();
                    }

                    Effects trails = new Effects(player);

                    switch (e.getSlot()) {
                        case 3:
                            if (player.hasPermission("Trails.totem")) {
                                trails.startTotem();
                                player.closeInventory();
                                player.updateInventory();
                                break;

                            }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        case 5:
                            if (player.hasPermission("Trails.heart")) {
                                trails.heartTrail();
                                player.closeInventory();
                                player.updateInventory();
                                break;
                            }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        default:
                            break;
                    }
                    if (e.getCurrentItem().getType() == Material.BARRIER) {
                        player.closeInventory();
                        particle.endTask();
                    } else {
                        return;
                    }


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














