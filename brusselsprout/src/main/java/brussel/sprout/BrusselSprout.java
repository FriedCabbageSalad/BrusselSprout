package brussel.sprout;

import org.bukkit.plugin.java.JavaPlugin;

import brussel.sprout.commands.CommandBackpack;
import brussel.sprout.storage.BackpackStorage;

/**
 * 
 * @author Kieran
 */
public class BrusselSprout extends JavaPlugin {
    private BackpackMap map;
    private final BackpackStorage storage = new BackpackStorage();
    private static BrusselSprout plugin;
    
    @Override
    public void onEnable() {
        getLogger().info("BrusselSprout Enabled!");
        plugin = this;

        getLogger().info("Loading Backpack Information from backpack_storage.json");
        map = new BackpackMap(storage.loadBackpackInfo());
        this.getCommand("backpack").setExecutor(new CommandBackpack(map));
    }

    @Override
    public void onDisable() {
        getLogger().info("BrusselSprout Disabled!");
        getLogger().info("Saving Backpack Information to backpack_storage.json");
        storage.saveBackpackInfo(map.getMap());
    }

    public static BrusselSprout getPlugin() {
        return plugin;
    }

}
