package brussel.sprout.storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import brussel.sprout.BackpackInventory;

public class BackpackStorage {
    private static final File file = new File("backpack_storage.yml");

    public static void saveBackpackInfo(HashMap<UUID, ArrayList<BackpackInventory>> map) {
        YamlConfiguration config = new YamlConfiguration();

        for (Map.Entry<UUID, ArrayList<BackpackInventory>> entry : map.entrySet()) {
            UUID uuid = entry.getKey();
            ArrayList<BackpackInventory> backpacks = entry.getValue();

            for (int i = 0; i < backpacks.size(); i++) {
                ItemStack[] contents = backpacks.get(i).getContents();
                config.set(uuid + "." + i, contents);
            }
        }

        try {
            config.save(file);
            System.out.println("Saving Backpack Information to backpack_storage.yml succeeded!");
        } catch (IOException e) {
            System.out.println("Saving Backpack Information to backpack_storage.yml failed!");
        }
    }

    public static HashMap<UUID, ArrayList<BackpackInventory>> loadBackpackInfo() {
        HashMap<UUID, ArrayList<BackpackInventory>> map = new HashMap<>();
        if (!file.exists()) return map;

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        for (String uuidStr : config.getKeys(false)) {
            UUID uuid = UUID.fromString(uuidStr);
            ArrayList<BackpackInventory> list = new ArrayList<>();

            for (String index : config.getConfigurationSection(uuidStr).getKeys(false)) {
                List<?> rawList = config.getList(uuidStr + "." + index);
                if (rawList == null) continue;

                ItemStack[] contents = rawList.toArray(new ItemStack[0]);
                BackpackInventory backpack = new BackpackInventory(contents.length);
                backpack.setContents(contents);
                list.add(backpack);
            }

            map.put(uuid, list);
        }
        System.out.println("Loading Backpack Information from backpack_storage.yml succeeded!");
        return map;
    }
}
