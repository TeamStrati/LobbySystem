package lobby_shop.LobbyShop.Nubsnils;

import lobby_shop.LobbyShop.Main;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(final String name) {
        return Main.getCfg().getConfiguration().getLocation(name);
    }

    public static void createWarp(final String name, final Location location) {
        Main.getCfg().set(name, location);
        Main.getCfg().save();
    }

    public static void deleteWarp(final String name) {
        Main.getCfg().set(name, null);
        Main.getCfg().save();
    }

}
