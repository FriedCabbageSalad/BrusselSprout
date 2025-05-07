package brussel.sprout;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * 
 * @author Kieran
 */
public class BackpackInventory {
    private Inventory backpack;
    private final List<Integer> SLOTS = Arrays.asList(9, 18, 27, 36, 45, 54);

    public BackpackInventory(int size) {
        this.backpack = Bukkit.createInventory(null, size);
    }

    public Inventory getBackpack() {
        return this.backpack;
    }

    public ItemStack[] getContents() {
        return this.backpack.getContents();
    }

    public int getSize() {
        return this.backpack.getSize();
    }

    public void setContents(ItemStack[] items) {
        this.backpack.setContents(items);
    }

    public BackpackInventory expandBackpackInventory(int factor) throws IndexOutOfBoundsException {
        int currSize = this.getSize();
        int newSize = SLOTS.get(SLOTS.indexOf(currSize) + factor);

        BackpackInventory newBackpack = new BackpackInventory(newSize);
        newBackpack.setContents(this.getContents());
        
        return newBackpack;
    }
}
