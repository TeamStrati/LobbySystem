package lobby_shop.LobbyShop;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class config {

    private static File config = new File("plugins//LobbyShop//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

    private static File PlayerData = new File("plugins//LobbyShop//playerdata.yml");
    private static YamlConfiguration PlayerDataList= YamlConfiguration.loadConfiguration(PlayerData);



    public static void configGeneration(){



        //PlayerData Configuration
        PlayerDataList.set("Orders.GrapplingHook", "");

        try {
            PlayerDataList.save(PlayerData);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
