package de.AlbraeTonomis.farmweltGui.cmds;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.plugin.Plugin;

//import de.AlbraeTonomis.farmweltGui.FarmweltGui;
import de.AlbraeTonomis.farmweltGui.Statics.Statics;


//import org.jetbrains.annotations.NotNull;

public class FarmweltCommand implements CommandExecutor, Listener{
	
	//private Plugin pl = FarmweltGui.getPlugin();
	private Statics st= new Statics();
		
	

	@Override
	public boolean onCommand(/*@NotNull*/ CommandSender arg0, /*@NotNull*/ Command arg1, /*@NotNull*/ String arg2,
			/*@NotNull*/ String[] arg3) {
		if(arg0 instanceof Player) {
			Player player=(Player) arg0;
			if(player.hasPermission("farmweltGui.farmwelt")) {
				if (arg3.length ==0){
					Inventory inv =Bukkit.createInventory(null, 9*1, "Farmwelten");
					
					ItemStack item1= new ItemStack(Material.GRASS_BLOCK);
					ItemMeta itemMeta= item1.getItemMeta();
					itemMeta.setDisplayName("§3Farmwelt1");
					item1.setItemMeta(itemMeta);
					inv.addItem(item1);
					
					
					
					player.openInventory(inv);
					player.sendMessage("§aKit Menue geöffnet");
				
				}
				else player.sendMessage("§cVerwende /kit");
					
				
			} else player.sendMessage("§cDu darfst diesen Befehl nicht verwenden");
				
				
			
		}
		else {
			arg0.sendMessage("Nur Spieler können diesen Command verwenden");
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClickOnItem(InventoryClickEvent event) {
		
		if (event.getWhoClicked() instanceof Player) {
			
			Player p = (Player) event.getWhoClicked();
			
			if (event.getView().getTitle().equals("Farmwelten")){
				
				event.setCancelled(true);
				
				try {
					
					if (event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
						
						ItemStack invstack = event.getCurrentItem();
							if (invstack.getType() == Material.GRASS_BLOCK) {
								
								p.teleport(st.getLocFarm1());
								p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 7, 1);
						}
						
						p.closeInventory();
						
					}
					
				} catch (Exception e) {
					
				}
				
			}
		}
		
	}

}