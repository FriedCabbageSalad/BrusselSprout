package brussel.sprout;

import org.bukkit.plugin.java.JavaPlugin;

import brussel.sprout.commands.CommandBackpack;
import brussel.sprout.storage.BackpackStorage;
import brussel.sprout.tabcompleters.BackpackTabCompleter;

/**
 * 
 * @author Kieran
 */
public class BrusselSprout extends JavaPlugin {
    private BackpackMap map;
    private static BrusselSprout plugin;
    
    @Override
    public void onEnable() {
        getLogger().info("BrusselSprout Enabled!");
        plugin = this;

        getLogger().info("Loading Backpack Information from backpack_storage.json");
        map = new BackpackMap(BackpackStorage.loadBackpackInfo());
        this.getCommand("backpack").setExecutor(new CommandBackpack(map));
        this.getCommand("backpack").setTabCompleter(new BackpackTabCompleter(map));
    }

    @Override
    public void onDisable() {
        getLogger().info("BrusselSprout Disabled!");
        getLogger().info("Saving Backpack Information to backpack_storage.json");
        BackpackStorage.saveBackpackInfo(map.getMap());
    }

    public static BrusselSprout getPlugin() {
        return plugin;
    }

}
