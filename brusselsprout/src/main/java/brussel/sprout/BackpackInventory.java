package brussel.sprout;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

/**
 * Hello world!
 *
 */
public class BackpackInventory implements Listener {
    private Inventory backpack;

    public BackpackInventory(Player player, int size) {
        this.backpack = Bukkit.createInventory(player, size);
    }

    public void openBackpack(Player player) {
        player.openInventory(this.backpack);
    }
}
