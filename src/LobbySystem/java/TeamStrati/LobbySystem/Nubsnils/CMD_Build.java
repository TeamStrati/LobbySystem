package TeamStrati.LobbySystem.Nubsnils;

import TeamStrati.LobbySystem.Main;
import TeamStrati.LobbySystem.commands.ItemManager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;


public class CMD_Build implements CommandExecutor {

    private File PlayerData = new File("plugins//LobbySystem//playerdata.yml");
    private YamlConfiguration PlayerDataList = YamlConfiguration.loadConfiguration(PlayerData);

    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    public static ArrayList<Player> build;

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        String BuildPermission = yamlConfiguration.getString("Permissions.build");
        if (p.hasPermission(BuildPermission)) {
            if (args.length == 0) {
                if (CMD_Build.build.contains(p)) {
                    CMD_Build.build.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.getInventory().clear();
                    UUID uuid = ((Player) sender).getUniqueId();
                    if (PlayerDataList.contains("Orders.GrapplingHook." + uuid)){
                        p.getInventory().addItem(ItemManager.GrapplingHook);
                    }
                    final ItemStack Navi = new ItemStack(Material.COMPASS);
                    final ItemMeta NaviMeta = Navi.getItemMeta();
                    NaviMeta.setDisplayName("§c§lNavigator");
                    Navi.setItemMeta(NaviMeta);
                    p.getInventory().setItem(3, Navi);
                    if (Main.noplayersvisible.contains(p.getUniqueId())) {
                        final ItemStack Hide = new ItemStack(Material.GRAY_DYE);
                        final ItemMeta HideMeta = Hide.getItemMeta();
                        HideMeta.setDisplayName("§7§lSpieler versteckt");
                        Hide.setItemMeta(HideMeta);
                        for (final Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.hidePlayer(Main.getInstance(), onlinePlayer);

                        }
                        p.getInventory().setItem(5, Hide);
                    }
                    else {
                        final ItemStack Hide = new ItemStack(Material.LIME_DYE);
                        final ItemMeta HideMeta = Hide.getItemMeta();
                        HideMeta.setDisplayName("§a§lSpieler sichtbar");
                        Hide.setItemMeta(HideMeta);
                        p.getInventory().setItem(5, Hide);
                    }

                    p.getInventory().setItem(8, ItemManager.EffectChest);
                    p.sendMessage(Main.prefix + "§aDu hast den §6Build §amode §c§ldeaktivert.");
                }
                else {
                    CMD_Build.build.add(p);
                    p.getInventory().clear();
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.prefix + "§aDu hast den §6Build §amode §a§laktiviert.");
                }
            }
        }
        else {
            p.sendMessage(Main.prefix + "§cDu hast keine Rechte dazu.");
        }
        return false;
    }

    static {
        CMD_Build.build = new ArrayList<Player>();
    }

}
