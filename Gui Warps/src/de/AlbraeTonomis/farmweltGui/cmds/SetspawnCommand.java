package de.AlbraeTonomis.farmweltGui.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.AlbraeTonomis.farmweltGui.FarmweltGui;


public class SetspawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0,  Command arg1,  String arg2,
			String[] arg3) {
		if(arg0 instanceof Player) {
			Player player=(Player) arg0;
			if(player.hasPermission("tutorial.setFarmwelt")) {
				if (arg3.length ==0){
					FileConfiguration config= FarmweltGui.getPlugin().getConfig();
					config.set("Farm1.World", player.getWorld().getName());
					config.set("Farm1.X", player.getLocation().getX());
					config.set("Farm1.Y", player.getLocation().getY());
					config.set("Farm1.Z", player.getLocation().getZ());
					config.set("Farm1.Yaw", player.getLocation().getYaw());
					config.set("Farm1.Pitch", player.getLocation().getPitch());
					FarmweltGui.getPlugin().saveConfig();
					player.sendMessage("Der Farm1 wurde verlegt");
				}
				else player.sendMessage("§cVerwende /setspawn");
					
				
			} else player.sendMessage("§cDu darfst diesen Befehl nicht verwenden");
				
				
			
		}
		else {
			arg0.sendMessage("Nur Spieler können diesen Command verwenden");
		}
		return false;
	}

}
