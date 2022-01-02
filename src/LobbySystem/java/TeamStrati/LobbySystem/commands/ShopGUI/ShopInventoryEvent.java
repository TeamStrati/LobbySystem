package TeamStrati.LobbySystem.commands.ShopGUI;

import TeamStrati.LobbySystem.Main;
import TeamStrati.LobbySystem.commands.ItemManager.ItemManager;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;

import static TeamStrati.LobbySystem.Main.*;



public class ShopInventoryEvent implements Listener {

    Main plugin;

    String UUID;

    private File config = new File("plugins//LobbySystem//config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    private File PlayerData = new File("plugins//LobbySystem//playerdata.yml");
    private YamlConfiguration PlayerDataList = YamlConfiguration.loadConfiguration(PlayerData);

    public ShopInventoryEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        try {


            Inventory inventory = e.getInventory();

            if (inventory != null) {

                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "Lobby Shop")) {

                    e.setCancelled(true);
                    try {

                        //Shop Menü
                        if (e.getCurrentItem().getType() == Material.BARRIER) {
                            player.closeInventory();
                        }
                        if (e.getCurrentItem().getType() == Material.FISHING_ROD) {


                            //In config eintragen:
                            UUID = player.getUniqueId().toString();
                            if (!PlayerDataList.contains("Orders.GrapplingHook." + UUID)) {

                                PlayerDataList.set("Orders.GrapplingHook." + UUID, true);

                                try {
                                    PlayerDataList.save(this.PlayerData);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                Integer PriceGH = yamlConfiguration.getInt("Price.grapplingHook");
                                if (econ.getBalance(player) >= PriceGH) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceGH);
                                    if (r.transactionSuccess()) {
                                        player.getInventory().addItem(ItemManager.GrapplingHook);
                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceGH +" Coins eine Grappling Hook gekauft!"));
                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }

                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du hast schon eine Grappling Hook, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                        if (e.getCurrentItem().getType() == Material.POPPY) {
                            Integer PriceHeart = yamlConfiguration.getInt("Price.heart");
                            String HeartPermission = yamlConfiguration.getString("Permissions.Trails.heart");
                            if (!player.hasPermission(HeartPermission)) {
                                if (econ.getBalance(player) >= PriceHeart) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceHeart);
                                    if (r.transactionSuccess()) {

                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceHeart +" Coins den Heart Effect Trail gekauft!"));

                                        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                                        //Permission für Heart Trail geben
                                        plugin.addPermission(user, HeartPermission);


                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }


                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du besitzt diesen Trail bereits, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                        if (e.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
                            String TotemPermission = yamlConfiguration.getString("Permissions.Trails.totem");
                            if (!player.hasPermission(TotemPermission)) {
                                Integer PriceTotem = yamlConfiguration.getInt("Price.totem");
                                if (econ.getBalance(player) >= PriceTotem) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceTotem);
                                    if (r.transactionSuccess()) {

                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceTotem+ " Coins den Totem Effect Trail gekauft!"));

                                        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                                        //Permission für Totem Trail geben
                                        plugin.addPermission(user, TotemPermission);


                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }


                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du besitzt diesen Trail bereits, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                        if (e.getCurrentItem().getType() == Material.EMERALD) {
                            String EmeraldHaloPermission = yamlConfiguration.getString("Permissions.Trails.EmeraldHalo");
                            if (!player.hasPermission(EmeraldHaloPermission)) {
                                Integer PriceTotem = yamlConfiguration.getInt("Price.EmeraldHalo");
                                if (econ.getBalance(player) >= PriceTotem) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceTotem);
                                    if (r.transactionSuccess()) {

                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceTotem+ " Coins den Emerald Halo gekauft!"));

                                        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                                        //Permission für Totem Trail geben
                                        plugin.addPermission(user, EmeraldHaloPermission);


                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }


                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du besitzt diesen Halo bereits, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                        if (e.getCurrentItem().getType() == Material.FIRE_CHARGE) {
                            String EmeraldHaloPermission = yamlConfiguration.getString("Permissions.Trails.AngryVillager");
                            if (!player.hasPermission(EmeraldHaloPermission)) {
                                Integer PriceTotem = yamlConfiguration.getInt("Price.AngryVillager");
                                if (econ.getBalance(player) >= PriceTotem) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceTotem);
                                    if (r.transactionSuccess()) {

                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceTotem+ " Coins den Angry Villager Trail gekauft!"));

                                        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                                        //Permission für Totem Trail geben
                                        plugin.addPermission(user, EmeraldHaloPermission);


                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }


                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du besitzt diesen Trail bereits, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                        if (e.getCurrentItem().getType() == Material.CAMPFIRE) {
                            String FirePermission = yamlConfiguration.getString("Permissions.Trails.fire");
                            if (!player.hasPermission(FirePermission)) {
                                Integer PriceFire = yamlConfiguration.getInt("Price.fire");
                                if (econ.getBalance(player) >= PriceFire) {
                                    EconomyResponse r = econ.withdrawPlayer(player, PriceFire);
                                    if (r.transactionSuccess()) {

                                        player.closeInventory();
                                        player.sendMessage(String.format(prefix + "Du hast für "+ PriceFire+ " Coins den Fire Trail gekauft!"));

                                        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                                        //Permission für Totem Trail geben
                                        plugin.addPermission(user, FirePermission);


                                    } else {
                                        player.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
                                    }
                                } else {
                                    player.sendMessage(String.format(prefix + "Du hast leider nicht genug geld"));
                                    player.closeInventory();
                                }


                            } else {
                                player.closeInventory();
                                player.sendMessage(prefix + "Du besitzt diesen Trail bereits, wenn du geld ausgeben möchtest mach" + ChatColor.DARK_PURPLE + " /spenden");
                            }
                        }
                    }catch (NullPointerException ex){}
                }
            } else {
                return;
            }
        }catch (NullPointerException ex){}
    }
}












