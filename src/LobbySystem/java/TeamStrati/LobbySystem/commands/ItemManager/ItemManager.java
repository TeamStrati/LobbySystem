package TeamStrati.LobbySystem.commands.ItemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack GrapplingHook;
    public static ItemStack EffectChest;
    public static ItemStack ScaffoldTool;


    public static void init() {
        createGrapplingHook();
        createEffectChest();
        createScaffoldTool();

    }


    private static void createGrapplingHook(){
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Grappling Hook");
        List<String> lore = new ArrayList<>();
        lore.add("§7Bewege dich schneller fort");

        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        GrapplingHook = item;
    }

    private static void createScaffoldTool(){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Scaffold Tool");
        List<String> lore = new ArrayList<>();
        lore.add("§7Wie hacks!");

        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        ScaffoldTool = item;
    }

    private static void createEffectChest(){
        ItemStack item = new ItemStack(Material.CHEST, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Effekte und Trails");
        List<String> lore = new ArrayList<>();
        lore.add("§7Verändere dein Aussehen");

        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        EffectChest = item;
    }

}
