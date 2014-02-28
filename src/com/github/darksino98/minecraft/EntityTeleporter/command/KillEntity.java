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
import org.bukkit.entity.Entity;

import org.bukkit.World;

import com.github.darksino98.minecraft.EntityTeleporter.EntityTeleporter;;

public final class KillEntity implements CommandExecutor
{
	private EntityTeleporter plugin;
	
	public KillEntity(EntityTeleporter plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		if (command.getName().equalsIgnoreCase("KillEntity")) //verify the name of the command
		{		
			if (args.length < 1) //if the command was called with no arguments
			{
				sender.sendMessage("KillEntity: Too few arguments!");
				return false; //display the usage string
			}
			
			if (args.length > 1) //if the command was called with too many arguments
			{
				sender.sendMessage("KillEntity: Too many arguments!");
				return false; //display the usage string
			}
			
			for(World world: plugin.getServer().getWorlds())
			{
				for(Entity entity: world.getEntities())
				{
					if(entity.getEntityId() == Integer.parseInt(args[0]) )
					{
						entity.remove();
					}
				}
			}
			
			return true;
		}
		
		return false; //display the usage string
	}

}
