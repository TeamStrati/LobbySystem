package TeamStrati.LobbySystem.Nubsnils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

import static TeamStrati.LobbySystem.Main.prefix;


public class Navigator implements Listener {

    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lNavigator") && (e.getAction().equals((Object) Action.RIGHT_CLICK_AIR) || e.getAction().equals((Object) Action.RIGHT_CLICK_BLOCK))) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 9, "§cNavigator");

                ItemStack Item1 = null;
                ItemStack Item2 = null;
                ItemStack Item3 = null;
                ItemStack Item4 = null;
                ItemStack Item5 = null;
                ItemStack Item6 = null;
                ItemStack Item7 = null;
                ItemStack Item8 = null;
                ItemStack Item9 = null;

                //Item Slot 1


                if (yamlConfiguration.getBoolean("Navigator Items.Slot1.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot1.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot1.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot1.Warp Name");
                    Item1 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item1Meta = Item1.getItemMeta();
                    Item1Meta.setDisplayName(ColoredDisplayName);
                    Item1Meta.setLocalizedName(WarpName);
                    Item1.setItemMeta(Item1Meta);
                }


                //Item Slot 2
                if (yamlConfiguration.getBoolean("Navigator Items.Slot2.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot2.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot2.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot2.Warp Name");
                    Item2 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item2Meta = Item2.getItemMeta();
                    Item2Meta.setDisplayName(ColoredDisplayName);
                    Item2Meta.setLocalizedName(WarpName);
                    Item2.setItemMeta(Item2Meta);
                }

                //Item Slot 3
                if (yamlConfiguration.getBoolean("Navigator Items.Slot3.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot3.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot3.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot3.Warp Name");
                    Item3 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item3Meta = Item3.getItemMeta();
                    Item3Meta.setDisplayName(ColoredDisplayName);
                    Item3Meta.setLocalizedName(WarpName);
                    Item3.setItemMeta(Item3Meta);
                }

                //Item Slot 4
                if (yamlConfiguration.getBoolean("Navigator Items.Slot4.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot4.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot4.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot4.Warp Name");
                    Item4 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item4Meta = Item4.getItemMeta();
                    Item4Meta.setDisplayName(ColoredDisplayName);
                    Item4Meta.setLocalizedName(WarpName);
                    Item4.setItemMeta(Item4Meta);
                }

                //Item Slot 5
                if (yamlConfiguration.getBoolean("Navigator Items.Slot5.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot5.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot5.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot5.Warp Name");
                    Item5 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item5Meta = Item5.getItemMeta();
                    Item5Meta.setDisplayName(ColoredDisplayName);
                    Item5Meta.setLocalizedName(WarpName);
                    Item5.setItemMeta(Item5Meta);
                }

                //Item Slot 6
                if (yamlConfiguration.getBoolean("Navigator Items.Slot6.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot6.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot6.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot6.Warp Name");
                    Item6 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item6Meta = Item6.getItemMeta();
                    Item6Meta.setDisplayName(ColoredDisplayName);
                    Item6Meta.setLocalizedName(WarpName);
                    Item6.setItemMeta(Item6Meta);
                }

                //Item Slot 7
                if (yamlConfiguration.getBoolean("Navigator Items.Slot7.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot7.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot7.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot7.Warp Name");
                    Item7 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item7Meta = Item7.getItemMeta();
                    Item7Meta.setDisplayName(ColoredDisplayName);
                    Item7Meta.setLocalizedName(WarpName);
                    Item7.setItemMeta(Item7Meta);
                }

                //Item Slot 8
                if (yamlConfiguration.getBoolean("Navigator Items.Slot8.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot8.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot8.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot8.Warp Name");
                    Item8 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item8Meta = Item8.getItemMeta();
                    Item8Meta.setDisplayName(ColoredDisplayName);
                    Item8Meta.setLocalizedName(WarpName);
                    Item8.setItemMeta(Item8Meta);
                }

                //Item Slot 9
                if (yamlConfiguration.getBoolean("Navigator Items.Slot9.enabled") == true) {
                    String material = yamlConfiguration.getString("Navigator Items.Slot9.Material");
                    String DisplayName = yamlConfiguration.getString("Navigator Items.Slot9.Display Name");
                    String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                    String WarpName = yamlConfiguration.getString("Navigator Items.Slot9.Warp Name");
                    Item9 = new ItemStack(Material.getMaterial(material));
                    final ItemMeta Item9Meta = Item9.getItemMeta();
                    Item9Meta.setDisplayName(ColoredDisplayName);
                    Item9Meta.setLocalizedName(WarpName);
                    Item9.setItemMeta(Item9Meta);
                }

                inv.setItem(0, Item1);
                inv.setItem(1, Item2);
                inv.setItem(2, Item3);
                inv.setItem(3, Item4);
                inv.setItem(4, Item5);
                inv.setItem(5, Item6);
                inv.setItem(6, Item7);
                inv.setItem(7, Item8);
                inv.setItem(8, Item9);


                p.openInventory(inv);
            }
        }
        catch (NullPointerException ex) {}
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cNavigator")) {
                e.setCancelled(true);
                try {
                    //warp Item 1
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot1.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot1.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot1.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        String WarpName = yamlConfiguration.getString("Navigator Items.Slot1.Warp Name");
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 2
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot2.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot2.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot2.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        String WarpName = yamlConfiguration.getString("Navigator Items.Slot2.Warp Name");
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 3
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot3.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot3.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot3.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 4
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot4.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot4.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot4.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 5
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot5.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot5.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot5.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 6
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot6.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot6.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot6.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 7
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot7.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot7.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot7.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                    //warp Item 8
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot8.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot8.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot8.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }
                    //warp Item 9
                    if (yamlConfiguration.getBoolean("Navigator Items.Slot9.enabled") == true) {
                        String material = yamlConfiguration.getString("Navigator Items.Slot9.Material");
                        String DisplayName = yamlConfiguration.getString("Navigator Items.Slot9.Display Name");
                        String ColoredDisplayName = ChatColor.translateAlternateColorCodes('&', DisplayName);
                        if (e.getCurrentItem().getType() == Material.getMaterial(material)) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColoredDisplayName) && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                                p.sendMessage(prefix + "§6Du hast dich zum " + ColoredDisplayName + " §6teleportiert");
                                p.closeInventory();
                            }
                        }
                    }

                }
                catch (NullPointerException ex) {}
            }
        }
        catch (NullPointerException ex2) {}
    }

    @EventHandler
    public void onClickBW(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        try {
            if (e.getView().getTitle().equalsIgnoreCase("§cNavigator")) {
                e.setCancelled(true);
                try {
                    if (e.getCurrentItem().getType() == Material.RED_BED && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lBedwars") && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                        e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                        p.sendMessage(prefix + "§6Du hast dich zu §d§lBedwars §6teleportiert");
                        p.closeInventory();
                    }
                }
                catch (NullPointerException ex) {}
            }
        }
        catch (NullPointerException ex2) {}
    }

}
