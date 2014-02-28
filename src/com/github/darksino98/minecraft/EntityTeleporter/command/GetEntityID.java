/*
 *	This file is part of EntityTeleporter.
 *
 *	Copyright (C) 2014 Maël A
 *
 *	EntityTeleporter is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  EntityTeleporter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with EntityTeleporter.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
 
/*
 * This plugin uses the Bukkit API version 1.6.4-R2.0
 * 
 * The bukkit is available under the terms of the GNU General Public License
 * version 3 as published by the Free Software Foundation.
 * 
 * Copyright(C) 2014 Bukkit contributors and others
 *
 */
 
package com.github.darksino98.minecraft.EntityTeleporter.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public final class GetEntityID implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		if (command.getName().equalsIgnoreCase("GetEntityID")) //verify the name of the command
		{
			if (!(sender instanceof Player)) //if command was NOT triggered by a player
			{
				sender.sendMessage("GetEntityID: This command can only be run by a player.");
				return true;
			} 
			
			if (args.length != 0) //if the command was called with arguments
			{
				sender.sendMessage("GetEntityId: Too many arguments!");
				return false; //display the usage string
			} 
			
			Player player = (Player) sender;
			
			Entity target = null;
	        double threshold = 1;
	        
	        for (Entity other:player.getWorld().getEntities()) //for each entity in the world of the player
	        {
	            Vector n = other.getLocation().toVector().subtract(player.getLocation().toVector()); //create a vector that is the translation from the player to the entity
	            if (player.getLocation().getDirection().normalize().crossProduct(n).lengthSquared() < threshold //test if the vectors (line of sight, vector n) are colinear
	            		&& n.normalize().dot(player.getLocation().getDirection().normalize()) >= 0) //test if the vectors have the same direction (colinear and not oposite)
	            {
	            	//test if there is an entity nearest
	                if (target == null || target.getLocation().distanceSquared(player.getLocation()) > other.getLocation().distanceSquared(player.getLocation()))
	                    target = other;
	            }
	        }
	        
	        if(target == null)
	        {
	        	player.sendMessage("&cGetEntityID: no target found.");
	        	return true;
	        }
	        
	        player.sendMessage("ID: " + String.valueOf(target.getEntityId()) );
			
			return true;
		}
		
		return false; //display the usage string
	}

}
