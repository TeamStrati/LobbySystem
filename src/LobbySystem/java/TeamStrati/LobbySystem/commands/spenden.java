package TeamStrati.LobbySystem.commands;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static TeamStrati.LobbySystem.Main.econ;
import static TeamStrati.LobbySystem.Main.prefix;


public class spenden implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        EconomyResponse r = econ.withdrawPlayer(player, 10);
        if (r.transactionSuccess()) {
            sender.sendMessage(String.format(prefix + "Du hast %s Coins an den Server gespendet!", econ.format(r.amount), econ.format(r.balance)));
        } else {
            sender.sendMessage(String.format(prefix + "An error occured: %s", r.errorMessage));
        }
        return true;
    }
}
