package de.AlbraeTonomis.farmweltGui.Statics;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.AlbraeTonomis.farmweltGui.FarmweltGui;


public class Statics {
	
	public  Location LocFarm1; 
	
	public Statics() {
		setStatics();
	}
	public void setStatics() {
		FileConfiguration config= FarmweltGui.getPlugin().getConfig();
		World world =Bukkit.getWorld(config.getString("Farm1.World"));
		double x= config.getDouble("Farm1.X");
		double y= config.getDouble("Farm1.Y");
		double z= config.getDouble("Farm1.Z");
		float yaw= (float)config.getDouble("Farm1.Yaw");
		float pitch= (float)config.getDouble("Farm1.Pitch");
		this.LocFarm1 = new Location(world,x,y,z,yaw,pitch);
	}
	
	public Location getLocFarm1() {
		return LocFarm1;
	}
}
