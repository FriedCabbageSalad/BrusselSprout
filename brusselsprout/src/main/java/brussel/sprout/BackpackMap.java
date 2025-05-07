package brussel.sprout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Kieran
 */
public class BackpackMap {
    private HashMap<UUID, ArrayList<BackpackInventory>> map;
    private final int DEFAULT_SIZE = 27;

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
        return map.get(pID).get(inventoryNumber);
    }

    public ArrayList<BackpackInventory> getList(UUID pID) {
        return map.get(pID);
    }

    public void addBackpack(UUID pID, int number) {
        ArrayList<BackpackInventory> curr = this.map.get(pID);
        ArrayList<BackpackInventory> ls = new ArrayList<>(number);

        for (int i = 0 ; i < number ; i++) {
            ls.add(new BackpackInventory(DEFAULT_SIZE));
        }
        
        if (curr == null) {
            this.map.put(pID, ls);
        } else {
            curr.addAll(ls);
        }
    }

    public void deleteBackpack(UUID pID, int inventoryNumber) {
        map.get(pID).remove(inventoryNumber);
    }

    public void replaceBackpack(UUID pID, int inventoryNumber, BackpackInventory newBackpackInventory) throws IndexOutOfBoundsException {
        ArrayList<BackpackInventory> ls = this.getList(pID);
        ls.set(inventoryNumber, newBackpackInventory);
    }

    public void expandBackpack(UUID pID, int inventoryNumber, int factor) throws IndexOutOfBoundsException {
        BackpackInventory newBackpackInventory = this.getBackpackInventory(pID, inventoryNumber).expandBackpackInventory(factor);
        replaceBackpack(pID, inventoryNumber, newBackpackInventory);
    }
}