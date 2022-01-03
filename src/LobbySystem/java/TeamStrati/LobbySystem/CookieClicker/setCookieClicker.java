package TeamStrati.LobbySystem.CookieClicker;

import TeamStrati.LobbySystem.Main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

import static TeamStrati.LobbySystem.Main.prefix;


public class setCookieClicker implements CommandExecutor {

    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = Main.getInstance();
        Player player = (Player) sender;
        String cookiePermission = yamlConfiguration.getString("Permissions.setcookie");
        Location pos = player.getLocation();


        if (player.hasPermission(cookiePermission)){
            player.sendMessage();
            //ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0, 0), EntityType.ARMOR_STAND);

            //hologram.setVisible(false);
            //hologram.setCustomNameVisible(true);
            //hologram.setCustomName(ChatColor.GOLD + "Cookie Clicker");

            player.performCommand("setblock ~ ~ ~ minecraft:gold_block");


        }else{
            player.sendMessage(prefix + "Dafür hast du keine rechte");
        }




        return false;
    }
}
