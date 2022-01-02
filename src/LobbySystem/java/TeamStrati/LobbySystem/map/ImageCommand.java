package TeamStrati.LobbySystem.map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import java.io.File;

import static TeamStrati.LobbySystem.Main.prefix;


public class ImageCommand implements CommandExecutor {

    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    String MapPermission;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        MapPermission = yamlConfiguration.getString("Permissions.map");
        if (player.hasPermission(MapPermission)){
            if (args.length == 0) {
                player.sendMessage(prefix + "Benutze /map <Link> um ein Bild zu bekommen.");
                return true;
            }

            MapView view = Bukkit.createMap(player.getWorld());
            view.getRenderers().clear();

            LogoRenderer renderer = new LogoRenderer();
            if (!renderer.load(args[0])) {
                player.sendMessage(prefix + "Das Bild konnte nicht geladen werden");
                return true;
            }
            view.addRenderer(renderer);

            ItemStack map = new ItemStack(Material.FILLED_MAP);
            MapMeta meta = (MapMeta) map.getItemMeta();

            // meta.setMapId(view.getId()); // old way of doing it
            meta.setMapView(view); // new way of doing it
            map.setItemMeta(meta);

            player.getInventory().addItem(map);
            player.sendMessage(prefix + "Das Bild wurde erstellt!");


            ImageManager manager = ImageManager.getInstance();
            manager.saveImage(view.getId(), args[0]);

        }else {
            player.sendMessage(prefix + "Du darfst das nicht benutzen");
        }
        return true;
    }

}
