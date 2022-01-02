package TeamStrati.LobbySystem.commands;

import org.bukkit.command.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;

import org.bukkit.*;
import net.md_5.bungee.api.chat.*;

import java.io.File;

import static TeamStrati.LobbySystem.Main.prefix;

public class discord implements CommandExecutor
{
    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;

            String Message1 = yamlConfiguration.getString("Discord.Message");
            String Message2 = yamlConfiguration.getString("Discord.Message2");
            String HoverMessage = yamlConfiguration.getString("Discord.HoverMessage");
            String link = yamlConfiguration.getString("Discord.Link");


            final TextComponent c = new TextComponent(prefix + Message1);
            final TextComponent clickme = new TextComponent(ChatColor.DARK_PURPLE + Message2);
            clickme.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
            clickme.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(ChatColor.YELLOW + HoverMessage)));
            c.addExtra((BaseComponent)clickme);
            p.spigot().sendMessage((BaseComponent)c);
        }
        return false;
    }
}
