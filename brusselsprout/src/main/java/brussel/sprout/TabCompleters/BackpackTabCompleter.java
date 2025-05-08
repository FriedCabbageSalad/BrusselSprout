package brussel.sprout.tabcompleters;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import brussel.sprout.BackpackMap;

public class BackpackTabCompleter implements TabCompleter {
    BackpackMap map;

    public BackpackTabCompleter(BackpackMap map) {
        this.map = map;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String aliasString, String[] argumentStrings) {
        ArrayList<String> completionStrings = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("backpack")) {
            if (argumentStrings.length == 1) {
                completionStrings.add("open");
                completionStrings.add("add");
                completionStrings.add("delete");
                completionStrings.add("expand");
                completionStrings.add("shrink");
                return completionStrings;
            }

            if (argumentStrings.length == 2) {
                if (sender instanceof Player player) {
                    UUID pID = player.getUniqueId();
                    int numberBackpacks = this.map.getList(pID).size();
                    for (int i = 1 ; i <= numberBackpacks ; i++) {
                        completionStrings.add(String.valueOf(i));
                    }
                    return completionStrings;
                }
            }
        }
        return completionStrings;
    }

}