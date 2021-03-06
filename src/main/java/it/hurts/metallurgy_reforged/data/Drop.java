/*
 * -------------------------------------------------------------------------------------------------------
 * Class: Drop
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2019.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.data;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class Drop {

	//private fields
	private ItemStack item;
	private float chance;

	//constructors
	@SuppressWarnings("unused")
	public Drop(ItemStack itemStack, int percentage)
	{
		this.item = itemStack;
		this.chance = (float) percentage / 100;
	}

	public Drop(ItemStack itemStack, float chance)
	{
		this.item = itemStack;
		this.chance = chance;
	}

	public Drop(Item item, int amount, float chance)
	{
		this.item = new ItemStack(item, amount);
		this.chance = chance;
	}

	//Custom Methods
	public ItemStack getItemStack()
	{
		return item;
	}

	public float getChance()
	{
		return chance;
	}

	@SuppressWarnings("unused")
	public int getAmount()
	{
		return item.getCount();
	}

	public int getRandomAmount()
	{
		return new Random().nextInt(item.getCount()) + 1;
	}

}
