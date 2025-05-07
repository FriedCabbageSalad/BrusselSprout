package brussel.sprout;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * 
 * @author Kieran
 */
public class BackpackInventory {
    private Inventory backpack;

    public BackpackInventory(int size) {
        this.backpack = Bukkit.createInventory(null, size);
    }

    public Inventory getBackpack() {
        return this.backpack;
    }

    public ItemStack[] getContents() {
        return backpack.getContents();
    }

    public void setContents(ItemStack[] items) {
        backpack.setContents(items);
    }
}
