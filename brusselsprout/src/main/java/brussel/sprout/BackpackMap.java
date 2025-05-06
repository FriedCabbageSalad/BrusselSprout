package brussel.sprout;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

/**
 *
 * @author Kieran
 */
public class BackpackMap {
    HashMap<Player, ArrayList<BackpackInventory>> map;

    public BackpackMap() {
        this.map = new HashMap<>();
    }

    public HashMap<Player, ArrayList<BackpackInventory>> getMap() {
        return this.map;
    }

    public BackpackInventory getBackpackInventory(Player player, int inventoryNumber) {
        return map.get(player).get(inventoryNumber - 1);
    }

    public void addBackpack(Player player, int number) {
        ArrayList<BackpackInventory> curr = this.map.get(player);
        ArrayList<BackpackInventory> ls = new ArrayList<>(number);

        for (int i = 0 ; i < number ; i++) {
            ls.add(new BackpackInventory(player, 27));
        }
        
        if (curr == null) {
            this.map.put(player, ls);
        } else {
            curr.addAll(ls);
        }
    }
}