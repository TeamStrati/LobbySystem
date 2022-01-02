package lobby_shop.LobbyShop.Nubsnils;

import lobby_shop.LobbyShop.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static lobby_shop.LobbyShop.Main.prefix;


public class CMD_Warp implements CommandExecutor, TabCompleter {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(prefix + "§cBitte nutze /warp add/remove");
            return false;
        }
        if (args.length == 1) {
            if (WarpManager.getWarp(args[0]) != null) {
                p.teleport(WarpManager.getWarp(args[0]));
                p.sendMessage(prefix + "§6Du wurdest zum Warp §d" + args[0] + "§6 teleportiert");
            }
            else {
                p.sendMessage(prefix + "§cDieser Warp existiert nicht!");
            }
        }
        else if (args.length == 2) {
            if (!p.hasPermission("LobbyV.Warps")) {
                p.sendMessage(prefix + "§cDu hast dazu keine Rechte!");
                return false;
            }
            if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("set")) {
                if (WarpManager.getWarp(args[1]) == null) {
                    WarpManager.createWarp(args[1], p.getLocation());
                    p.sendMessage(prefix+ "§6Du hast den Warp §d" + args[1] + "§6 erstellt");
                }
                else {
                    p.sendMessage(prefix + "§cDieser Warp existiert bereits!");
                }
            }
            else if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("delete")) {
                if (WarpManager.getWarp(args[1]) != null) {
                    WarpManager.deleteWarp(args[1]);
                    p.sendMessage(prefix + "§6Du hast den Warp §d" + args[1] + "§6 gel\u00f6scht");
                }
                else {
                    p.sendMessage(prefix+ "§cDieser Warp existiert nicht!");
                }
            }
        }
        return false;
    }

    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        final ArrayList<String> list = new ArrayList<String>();
        if (args.length == 0) {
            return list;
        }
        if (args.length == 1) {
            list.add("add");
            list.add("set");
            list.add("remove");
            list.add("delete");
        }
        final ArrayList<String> completerList = new ArrayList<String>();
        final String currentarg = args[args.length - 1].toLowerCase();
        for (final String s : list) {
            final String s2 = s.toLowerCase();
            if (s2.startsWith(currentarg)) {
                completerList.add(s);
            }
        }
        return completerList;
    }

}
