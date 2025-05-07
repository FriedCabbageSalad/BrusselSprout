package brussel.sprout.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import brussel.sprout.BackpackInventory;
import brussel.sprout.BackpackMap;
/**
 *
 * @author Kieran
 */
public class CommandBackpack implements CommandExecutor {
    BackpackMap map;

    public CommandBackpack(BackpackMap map) {
        this.map = map;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Checks if sender is a Player, exit if not
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("This command does not work on non-player entities!");
            return true;

        }

        Player player = (Player) sender;
        UUID pID= player.getUniqueId();
        
        // Checks correct argument length
        if (args.length == 2) {
            String subCommand = args[0].toLowerCase();
            String numberString = args[1];
            int number;
            int index;

            try {
                number = Integer.parseInt(numberString);
                index = number - 1;   
            } catch (NumberFormatException e) {
                player.sendMessage("Argument should be a number.");
                player.sendMessage("Usage: /backpack <number>");
                return true;
            }

            switch (subCommand) {
                case "open":
                    BackpackInventory currInv = map.getBackpackInventory(pID, index);
                    player.openInventory(currInv.getBackpack());
                    player.sendMessage(String.format("Opened backpack %s.", number));
                    break;
                case "add":
                    this.map.addBackpack(pID, index);
                    player.sendMessage(String.format("Added %s backpacks.", number));
                    break;
                case "delete":
                    this.map.deleteBackpack(pID, index);
                    player.sendMessage(String.format("Deleted backpack %s.", number));
                    break;
                case "expand":
                    this.map.expandBackpack(pID, index, 1);
                    player.sendMessage(String.format("Expanded backpack %s.", number));
                    break;
            }

        } else {
            player.sendMessage("Incorrect use of command.");
            player.sendMessage("Usage: /backpack <number>");
        }

        return true;
    }
}
