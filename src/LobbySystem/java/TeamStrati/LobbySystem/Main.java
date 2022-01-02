package TeamStrati.LobbySystem;

import TeamStrati.LobbySystem.Nubsnils.*;
import TeamStrati.LobbySystem.commands.EffectGUI.EffectGUI;
import TeamStrati.LobbySystem.commands.EffectGUI.EffectInventoryEvent;
import TeamStrati.LobbySystem.commands.ItemManager.ItemEvents;
import TeamStrati.LobbySystem.commands.ItemManager.ItemManager;
import TeamStrati.LobbySystem.commands.ShopGUI.ShopGUI;
import TeamStrati.LobbySystem.commands.ShopGUI.ShopInventoryEvent;
import TeamStrati.LobbySystem.commands.spenden;

import TeamStrati.LobbySystem.listener.CancelInventorySwapEvent;
import TeamStrati.LobbySystem.listener.Join;
import TeamStrati.LobbySystem.trails.Quit;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;


public final class Main extends JavaPlugin {

    private static Config cfg;
    public static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;

    private static File config = new File("plugins//LobbySystem//config.yml");
    private static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);


    //public static String prefix = ChatColor.AQUA + "[" + ChatColor.GREEN + "Teudaria" + ChatColor.AQUA + "]" + ChatColor.YELLOW + " ";

    public static String prefixConfig = "&b[&aTeudaria&b] &e";
    public static String prefix;
    //public static String prefixConfig = yamlConfiguration.getString("Prefix");
    //public static String prefix = ChatColor.translateAlternateColorCodes('&', prefixConfig);
    private static Main instance;


    public static ArrayList<UUID> noplayersvisible;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("| | L O B B Y  S Y S T E M| |");
        System.out.println("by TeamStrati");
        System.out.println(" Plugin erfolgreich geladen!");
        //this.loadConfig();
        if (!new File(this.getDataFolder() + File.separator + "config.yml").exists()) {
            this.saveDefaultConfig();
        }
        try {
            new YamlConfiguration().load(new File(this.getDataFolder() + File.separator + "config.yml"));
        } catch (Exception e) {
            System.out.println("--- --- --- ---");
            System.out.println("There was an error loading your Config file.");
            System.out.println("A detailed description of your error is shown below.");
            System.out.println("--- --- --- ---");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin((Plugin) this);
            //return false;
        }

        Main.noplayersvisible = new ArrayList<UUID>();

        Main.cfg = new Config("Warps.yml", this.getDataFolder());
        Main.instance = this;
        if(yamlConfiguration.getString("Prefix") != null){
            prefixConfig = yamlConfiguration.getString("Prefix");
        }else {
            prefixConfig = "[Bitte Prefix setzen oder Neuladen] ";
        }

        prefix = ChatColor.translateAlternateColorCodes('&', prefixConfig);
        this.getCommand("warp").setExecutor((CommandExecutor)new CMD_Warp());
        this.getCommand("build").setExecutor((CommandExecutor)new CMD_Build());
        Bukkit.getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);

        Bukkit.getPluginManager().registerEvents((Listener)new Navigator(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerHider(), (Plugin)this);



        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
        ItemManager.init();
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();

        }




        getCommand("spenden").setExecutor(new spenden());


        getCommand("shop").setExecutor(new ShopGUI(this));
        getServer().getPluginManager().registerEvents(new ShopInventoryEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new ItemEvents(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);


        getCommand("effects").setExecutor(new EffectGUI(this));
        getServer().getPluginManager().registerEvents(new EffectInventoryEvent(this), this);
        getServer().getPluginManager().registerEvents(new CancelInventorySwapEvent(), this);
        getServer().getPluginManager().registerEvents(new Quit(), this);



        //this.loadConfig();
       // this.loadPlayerData();


        //Config
        // KEY -> Wert / Message: 'text'
        //reinschreiben:
        //yamlConfiguration.set("TestNachricht", "Test");
        //try {
        //    yamlConfiguration.save(this.config);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //auslesen:
        //String configString = yamlConfiguration.getString(("TestNachricht"));




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("| | L O B B Y  S Y S T E M| |");
        System.out.println("by TeamStrati");
        System.out.println(" Plugin erfolgreich entladen!");
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    public boolean loadConfig() {
        if (!new File(this.getDataFolder() + File.separator + "config.yml").exists()) {
            this.saveDefaultConfig();
        }
        try {
            new YamlConfiguration().load(new File(this.getDataFolder() + File.separator + "config.yml"));
            prefixConfig = yamlConfiguration.getString("Prefix");
            prefix = ChatColor.translateAlternateColorCodes('&', prefixConfig);

        } catch (Exception e) {
            System.out.println("--- --- --- ---");
            System.out.println("There was an error loading your configuration.");
            System.out.println("A detailed description of your error is shown below.");
            System.out.println("--- --- --- ---");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin((Plugin) this);

            return false;

        }


        return true;
    }
    public boolean loadPlayerData() {
        if (!new File(this.getDataFolder() + File.separator + "playerdata.yml").exists()) {
            this.saveDefaultConfig();
        }
        try {
            new YamlConfiguration().load(new File(this.getDataFolder() + File.separator + "playerdata.yml"));
        } catch (Exception e) {
            System.out.println("--- --- --- ---");
            System.out.println("There was an error loading your PlayerData file.");
            System.out.println("A detailed description of your error is shown below.");
            System.out.println("--- --- --- ---");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin((Plugin) this);
            return false;
        }
        return true;
    }



    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public void openShopMenu(Player player) {

        Inventory ShopMenu = Bukkit.createInventory(player, 27, ChatColor.YELLOW + "Lobby Shop");

        //Items

        //Grappling Hook
        ItemStack grapplingHook = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta Rod_Meta = grapplingHook.getItemMeta();
        Rod_Meta.setDisplayName(ChatColor.GREEN + "Grappling Hook");
        ArrayList<String> Rod_lore = new ArrayList<>();
        Integer PriceGH = yamlConfiguration.getInt("Price.grapplingHook");
        Rod_lore.add(ChatColor.GOLD + "Kaufe eine Grappling Hook " + ChatColor.GREEN + "("+PriceGH+" Coins)");
        Rod_Meta.setLore(Rod_lore);
        grapplingHook.setItemMeta(Rod_Meta);

        ShopMenu.setItem(0, grapplingHook);

        //heart effect trail
        ItemStack heart = new ItemStack(Material.POPPY, 1);
        ItemMeta heart_Meta = heart.getItemMeta();
        heart_Meta.setDisplayName(ChatColor.GREEN + "Heart effect Trail");
        ArrayList<String> heart_lore = new ArrayList<>();
        Integer PriceHeart = yamlConfiguration.getInt("Price.heart");
        heart_lore.add(ChatColor.GOLD + "Kaufe diesen Trail " + ChatColor.GREEN + "("+PriceHeart+" Coins)");
        heart_Meta.setLore(heart_lore);
        heart.setItemMeta(heart_Meta);

        ShopMenu.setItem(9, heart);

        //Totem effect trail
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemMeta totem_Meta = totem.getItemMeta();
        totem_Meta.setDisplayName(ChatColor.GREEN + "Totem effect Trail");
        ArrayList<String> totem_lore = new ArrayList<>();
       Integer PriceTotem = yamlConfiguration.getInt("Price.totem");
        totem_lore.add(ChatColor.GOLD + "Kaufe diesen Trail " + ChatColor.GREEN + "("+PriceTotem+" Coins)");
        totem_Meta.setLore(totem_lore);
        totem.setItemMeta(totem_Meta);

        ShopMenu.setItem(10, totem);

        //schließen
        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta test_meta = barrier.getItemMeta();
        test_meta.setDisplayName(ChatColor.RED + "Schliessen");
        barrier.setItemMeta(test_meta);
        ShopMenu.setItem(26, barrier);

        //open Inventory
        player.openInventory(ShopMenu);

    }

    public void openEffectsMenu(Player player) {

        Inventory EffectMenu = Bukkit.createInventory(player, 27, ChatColor.YELLOW + "Effekte und Trails");


        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Totem Trail");
        item.setItemMeta(meta);
        EffectMenu.setItem(3, item);

        item = new ItemStack(Material.POPPY);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Heart Trail");
        item.setItemMeta(meta);
        EffectMenu.setItem(5, item);


        //schließen
        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta test_meta = barrier.getItemMeta();
        test_meta.setDisplayName(ChatColor.RED + "Effekte beenden");
        barrier.setItemMeta(test_meta);
        EffectMenu.setItem(22, barrier);

        //open Inventory
        player.openInventory(EffectMenu);
    }


    public void addPermission(User user, String permission) {
        // Add the permission
        user.data().add(Node.builder(permission).build());

        // Now we need to save changes.
        //luckPerms.getUserManager().saveUser(user);
        LuckPermsProvider.get().getUserManager().saveUser(user);
    }




    public static Main getInstance() {
        return Main.instance;
    }

    public static Config getCfg() {
        return Main.cfg;
    }

}
