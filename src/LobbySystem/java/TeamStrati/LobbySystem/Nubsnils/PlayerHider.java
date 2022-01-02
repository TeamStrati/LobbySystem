package TeamStrati.LobbySystem.Nubsnils;

import TeamStrati.LobbySystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;


public class PlayerHider implements Listener {


    ArrayList<String> onCooldown;

    public PlayerHider() {
        this.onCooldown = new ArrayList<String>();
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getItem() != null && (e.getItem().getType().equals((Object) Material.LIME_DYE) || e.getItem().getType().equals((Object)Material.GRAY_DYE)) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && !this.onCooldown.contains(p.getName())) {
            this.onCooldown.add(p.getName());
            if (Main.noplayersvisible.contains(e.getPlayer().getUniqueId())) {
                final ItemStack Hide = new ItemStack(Material.LIME_DYE);
                final ItemMeta HideMeta = Hide.getItemMeta();
                HideMeta.setDisplayName("§a§lSpieler sichtbar");
                Hide.setItemMeta(HideMeta);
                e.getPlayer().getInventory().setItem(6, Hide);
                e.getPlayer().updateInventory();
                e.getPlayer().sendMessage(Main.prefix + "§aDu kannst nun wieder §2alle Spieler §asehen!");
                p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.1f, 0.5f);
                Main.noplayersvisible.remove(e.getPlayer().getUniqueId());
                for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    e.getPlayer().showPlayer((Plugin)Main.getInstance(), onlinePlayer);
                }
            }
            else {
                final ItemStack Hide = new ItemStack(Material.GRAY_DYE);
                final ItemMeta HideMeta = Hide.getItemMeta();
                HideMeta.setDisplayName("§7§lSpieler versteckt");
                Hide.setItemMeta(HideMeta);
                e.getPlayer().getInventory().setItem(6, Hide);
                e.getPlayer().updateInventory();
                e.getPlayer().sendMessage(Main.prefix + "§aDu siehst nun §ckeine Spieler §amehr!");
                p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.1f, 0.5f);
                Main.noplayersvisible.add(e.getPlayer().getUniqueId());
                for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    e.getPlayer().hidePlayer((Plugin)Main.getInstance(), onlinePlayer);
                }
            }
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> this.onCooldown.remove(p.getName()), 20L);
        }
    }

}
