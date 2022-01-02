package lobby_shop.LobbyShop.Nubsnils;

import lobby_shop.LobbyShop.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

import static lobby_shop.LobbyShop.Main.prefix;


public class CMD_Build implements CommandExecutor {

    public static ArrayList<Player> build;

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("LobbyV.Build")) {
            if (args.length == 0) {
                if (CMD_Build.build.contains(p)) {
                    CMD_Build.build.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.getInventory().clear();
                    final ItemStack Navi = new ItemStack(Material.COMPASS);
                    final ItemMeta NaviMeta = Navi.getItemMeta();
                    NaviMeta.setDisplayName("§c§lNavigator");
                    Navi.setItemMeta(NaviMeta);
                    p.getInventory().setItem(4, Navi);
                    if (Main.noplayersvisible.contains(p.getUniqueId())) {
                        final ItemStack Hide = new ItemStack(Material.GRAY_DYE);
                        final ItemMeta HideMeta = Hide.getItemMeta();
                        HideMeta.setDisplayName("§7§lSpieler versteckt");
                        Hide.setItemMeta(HideMeta);
                        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.hidePlayer((Plugin)Main.getInstance(), onlinePlayer);
                        }
                        p.getInventory().setItem(6, Hide);
                    }
                    else {
                        final ItemStack Hide = new ItemStack(Material.LIME_DYE);
                        final ItemMeta HideMeta = Hide.getItemMeta();
                        HideMeta.setDisplayName("§a§lSpieler sichtbar");
                        Hide.setItemMeta(HideMeta);
                        p.getInventory().setItem(6, Hide);
                    }
                    p.sendMessage(prefix + "§aDu hast den §6Build §amode §c§ldeaktivert.");
                }
                else {
                    CMD_Build.build.add(p);
                    p.getInventory().clear();
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(prefix + "§aDu hast den §6Build §amode §a§laktiviert.");
                }
            }
        }
        else {
            p.sendMessage(prefix + "§cDu hast keine Rechte dazu.");
        }
        return false;
    }

    static {
        CMD_Build.build = new ArrayList<Player>();
    }

}
