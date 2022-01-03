package TeamStrati.LobbySystem.CookieClicker;

import me.clip.placeholderapi.libs.kyori.adventure.text.NBTComponent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static TeamStrati.LobbySystem.Main.*;

public class CookieHandler implements Listener {

    public static File cookies = new File("plugins//LobbySystem//cookies.yml");

    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cookies);

    public static HashMap<Player, Integer> l = new HashMap<>();


    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        String pname = e.getPlayer().getName();
        try {

            if (e.getClickedBlock().getType() == Material.GOLD_BLOCK){

                    l.put(p, l.get(p) + 1);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a-- Du hast " + l.get(p) + " Cookies --"));
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 1);
                    if (l.get(p) % 500 == 0) {
                        EconomyResponse r = econ.depositPlayer(p, 100);
                        p.sendMessage(prefix + "Du hast 100 Coins beim " + ChatColor.DARK_PURPLE + "Cookie Clicken " + ChatColor.YELLOW + "verdient!");

                    }



            }


        }catch (Exception e1){ }
        return;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        if (cfg.get("CookieClicker."+p.getUniqueId() + ".Cookies") == null){
            cfg.set("CookieClicker."+p.getUniqueId() + ".Cookies", 0);
            try {
                cfg.save(cookies);
            }catch (IOException e1){
                e1.printStackTrace();
            }
            l.put(p, 0);

        }else {
            l.put(p, cfg.getInt("CookieClicker."+p.getUniqueId() +".Cookies"));
        }
        p.setResourcePack("");

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        cfg.set("CookieClicker."+p.getUniqueId() + ".Cookies", l.get(p));
        try {
            cfg.save(cookies);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}



