package TeamStrati.LobbySystem.ImageMaps;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class ImageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Wrong Usage, /map <link>");
            return true;
        }

        MapView view = Bukkit.createMap(player.getWorld());
        view.getRenderers().clear();

        LogoRenderer renderer = new LogoRenderer();
        if (!renderer.load(args[0])) {
            player.sendMessage("Image could not be loaded!");
            return true;
        }
        view.addRenderer(renderer);

        ItemStack map = new ItemStack(Material.FILLED_MAP);
        MapMeta meta = (MapMeta) map.getItemMeta();

        // meta.setMapId(view.getId()); // old way of doing it
        meta.setMapView(view); // new way of doing it
        map.setItemMeta(meta);

        player.getInventory().addItem(map);
        player.sendMessage("Image Created!");


        ImageManager manager = ImageManager.getInstance();
        manager.saveImage(view.getId(), args[0]);
        return true;
    }

}
