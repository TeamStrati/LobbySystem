package lobby_shop.LobbyShop.commands.ShopGUI;

import lobby_shop.LobbyShop.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopGUI implements CommandExecutor {


    Main plugin;

    public ShopGUI(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

                plugin.openShopMenu(player);


        }


        return true;
    }

}
