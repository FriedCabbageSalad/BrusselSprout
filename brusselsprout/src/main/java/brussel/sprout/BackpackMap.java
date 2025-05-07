package brussel.sprout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Kieran
 */
public class BackpackMap {
    HashMap<UUID, ArrayList<BackpackInventory>> map;

    public BackpackMap() {
        this.map = new HashMap<>();
    }

    public BackpackMap(HashMap<UUID, ArrayList<BackpackInventory>> map) {
        this.map = map;
    }

    public HashMap<UUID, ArrayList<BackpackInventory>> getMap() {
        return this.map;
    }

    public BackpackInventory getBackpackInventory(UUID pID, int inventoryNumber) {
        return map.get(pID).get(inventoryNumber - 1);
    }

    public void addBackpack(UUID pID, int number) {
        ArrayList<BackpackInventory> curr = this.map.get(pID);
        ArrayList<BackpackInventory> ls = new ArrayList<>(number);

        for (int i = 0 ; i < number ; i++) {
            ls.add(new BackpackInventory(27));
        }
        
        if (curr == null) {
            this.map.put(pID, ls);
        } else {
            curr.addAll(ls);
        }
    }
}