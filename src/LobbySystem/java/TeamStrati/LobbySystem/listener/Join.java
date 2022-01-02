package TeamStrati.LobbySystem.listener;

import TeamStrati.LobbySystem.Main;
import TeamStrati.LobbySystem.Nubsnils.WarpManager;
import TeamStrati.LobbySystem.commands.ItemManager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;


public class Join implements Listener {

    String UUID;

    private File PlayerData = new File("plugins//LobbySystem//playerdata.yml");
    private YamlConfiguration PlayerDataList = YamlConfiguration.loadConfiguration(PlayerData);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        UUID = p.getUniqueId().toString();
        p.getInventory().clear();

        if (PlayerDataList.contains("Orders.GrapplingHook." + UUID)){
            p.getInventory().addItem(ItemManager.GrapplingHook);
        }
        p.getInventory().setItem(8, ItemManager.EffectChest);

        e.setJoinMessage("");

        p.setGameMode(GameMode.SURVIVAL);
        p.setFoodLevel(20);
        if (WarpManager.getWarp("spawn") != null) {
            p.teleport(WarpManager.getWarp("spawn"));
        }
        else {
            p.sendMessage(Main.prefix + "§cBitte setze den Spawn");
        }
        ItemStack Navi = new ItemStack(Material.COMPASS);
        ItemMeta NaviMeta = Navi.getItemMeta();
        NaviMeta.setDisplayName("§c§lNavigator");
        Navi.setItemMeta(NaviMeta);
        p.getInventory().setItem(3, Navi);
        if (Main.noplayersvisible.contains(e.getPlayer().getUniqueId())) {
            ItemStack Hide = new ItemStack(Material.GRAY_DYE);
            ItemMeta HideMeta = Hide.getItemMeta();
            HideMeta.setDisplayName("§7§lSpieler versteckt");
            Hide.setItemMeta(HideMeta);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.hidePlayer((Plugin)Main.getInstance(), onlinePlayer);
            }
            e.getPlayer().getInventory().setItem(6, Hide);
        }
        else {
            ItemStack Hide = new ItemStack(Material.LIME_DYE);
            ItemMeta HideMeta = Hide.getItemMeta();
            HideMeta.setDisplayName("§a§lSpieler sichtbar");
            Hide.setItemMeta(HideMeta);
            e.getPlayer().getInventory().setItem(5, Hide);
        }
        for (java.util.UUID onlinePlayer2 : Main.noplayersvisible) {
            if (Bukkit.getPlayer(onlinePlayer2) != null) {
                Bukkit.getPlayer(onlinePlayer2).hidePlayer((Plugin)Main.getInstance(), e.getPlayer());
            }
        }

    }

}
