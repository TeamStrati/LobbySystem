package TeamStrati.LobbySystem.commands.EffectGUI;

import TeamStrati.LobbySystem.Main;
import TeamStrati.LobbySystem.trails.Effects;
import TeamStrati.LobbySystem.trails.ParticleData;
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

import static TeamStrati.LobbySystem.Main.prefix;



public class EffectInventoryEvent implements Listener {

    Main plugin;

    String UUID;

    private File config = new File("plugins//LobbySystem//config.yml");
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
                        case 0:
                            String TotemPermission = yamlConfiguration.getString("Permissions.Trails.totem");
                            if (player.hasPermission(TotemPermission)) {
                                trails.startTotem();
                                player.closeInventory();
                                player.updateInventory();
                                break;

                            }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        case 2:
                            String HeartPermission = yamlConfiguration.getString("Permissions.Trails.heart");
                            if (player.hasPermission(HeartPermission)) {
                                trails.heartTrail();
                                player.closeInventory();
                                player.updateInventory();
                                break;
                            }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        case 4:
                            String AngryVillagerPermission = yamlConfiguration.getString("Permissions.Trails.AngryVillager");
                            if (player.hasPermission(AngryVillagerPermission)) {
                                trails.AngryHead();
                                player.closeInventory();
                                player.updateInventory();
                                break;
                            }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        case 6:
                            String EmeraldHaloPermission = yamlConfiguration.getString("Permissions.Trails.EmeraldHalo");
                            if (player.hasPermission(EmeraldHaloPermission)) {
                            trails.EmeraldHalo();
                            player.closeInventory();
                            player.updateInventory();
                            break;

                        }else {
                                player.sendMessage(prefix + "Du hast diesen Trail noch nicht freigeschlaten. Kaufe ihn mit /shop");
                                break;
                            }
                        case 8:
                            String FirePermission = yamlConfiguration.getString("Permissions.Trails.fire");
                            if (player.hasPermission(FirePermission)) {
                                trails.FeueruntermHintern();
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














