package TeamStrati.LobbySystem.Nubsnils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

import static TeamStrati.LobbySystem.Main.prefix;


public class Navigator implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lNavigator") && (e.getAction().equals((Object) Action.RIGHT_CLICK_AIR) || e.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK))) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§cNavigator");
                final ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
                final ItemMeta SpawnMeta = Spawn.getItemMeta();
                SpawnMeta.setDisplayName("§6§lSpawn");
                SpawnMeta.setLocalizedName("spawn");
                Spawn.setItemMeta(SpawnMeta);
                final ItemStack CB = new ItemStack(Material.IRON_AXE);
                final ItemMeta CBMeta = CB.getItemMeta();
                CBMeta.setDisplayName("§b§lCityBuild");
                CBMeta.setLocalizedName("citybuild");
                CB.setItemMeta(CBMeta);
                final ItemStack ACADE = new ItemStack(Material.MUSIC_DISC_MALL);
                final ItemMeta ACADEMeta = ACADE.getItemMeta();
                ACADEMeta.setDisplayName("§d§lMinigames");
                ACADEMeta.setLocalizedName("minigames");
                ACADE.setItemMeta(ACADEMeta);
                inv.setItem(4, Spawn);
                inv.setItem(2, CB);
                inv.setItem(6, ACADE);
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
                    if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpawn") && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                            e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                            p.sendMessage(prefix + "§6Du hast dich zum §d§lSpawn §6teleportiert");
                            p.closeInventory();
                        }
                    }
                    else if (e.getCurrentItem().getType() == Material.IRON_AXE) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lCityBuild") && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                            e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                            p.sendMessage(prefix + "§6Du hast dich zu §d§lCityBuild §6teleportiert");
                            p.closeInventory();
                        }
                    }
                    else if (e.getCurrentItem().getType() == Material.MUSIC_DISC_MALL && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lMinigames") && WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null) {
                        e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.1f, 1.0f);
                        p.sendMessage(prefix+ "§6Du hast dich zu §d§lMinigames §6teleportiert");
                        p.closeInventory();
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
