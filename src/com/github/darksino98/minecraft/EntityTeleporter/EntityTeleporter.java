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

package com.github.darksino98.minecraft.EntityTeleporter;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.darksino98.minecraft.EntityTeleporter.command.*;

public final class EntityTeleporter extends JavaPlugin
{

	 	@Override
	    public void onEnable()
	 	{
	 		getCommand("getentityid").setExecutor( new GetEntityID() );
	 		getCommand("killentity").setExecutor( new KillEntity(this) );
	    }
	 
	    @Override
	    public void onDisable()
	    {
	    }
}
