package brussel.sprout.commands;

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

        // Checks correct argument length
        if (args.length == 2) {
            String subCommand = args[0].toLowerCase();
            String numbeString = args[1];
            int number;

            try {
                number = Integer.parseInt(numbeString);    
            } catch (NumberFormatException e) {
                player.sendMessage("Argument should be a number.");
                player.sendMessage("Usage: /backpack <number>");
                return true;
            }

            if (subCommand.equals("open")) {
                BackpackInventory currInv = map.getBackpackInventory(player, number);
                currInv.openBackpack(player);
            } else if (subCommand.equals("add")) {
                this.map.addBackpack(player, number);
            }

        } else {
            player.sendMessage("Incorrect use of command.");
            player.sendMessage("Usage: /backpack <number>");
        }

        return true;
    }
}
