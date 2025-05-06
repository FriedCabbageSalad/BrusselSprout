package brussel.sprout;

import org.bukkit.plugin.java.JavaPlugin;

import brussel.sprout.commands.CommandBackpack;

/**
 * Hello world!
 *
 */
public class BrusselSprout extends JavaPlugin {
    private BackpackMap map = new BackpackMap();

    @Override
    public void onEnable() {
        getLogger().info("BrusselSprout Enabled!");
        this.getCommand("backpack").setExecutor(new CommandBackpack(map));
    }

    @Override
    public void onDisable() {
        getLogger().info("BrusselSprout Disabled!");
    }

}
