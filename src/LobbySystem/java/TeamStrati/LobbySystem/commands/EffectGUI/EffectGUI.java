package TeamStrati.LobbySystem.commands.EffectGUI;

import TeamStrati.LobbySystem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EffectGUI implements CommandExecutor{




        Main plugin;

        public EffectGUI(Main plugin) {
            this.plugin = plugin;
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (sender instanceof Player){
                Player player = (Player) sender;

                plugin.openEffectsMenu(player);


            }


            return true;
        }



}
