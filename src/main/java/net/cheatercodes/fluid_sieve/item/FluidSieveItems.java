package net.cheatercodes.fluid_sieve.item;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.cheatercodes.fluid_sieve.block.FluidSieveBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidSieveItems {
    public static final BlockItem BASE = new BlockItem(FluidSieveBlocks.BASE, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem NET = new BlockItem(FluidSieveBlocks.NET, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem DENSE_NET = new BlockItem(FluidSieveBlocks.DENSE_NET, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static final Item MESH = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item DENSE_MESH = new Item(new Item.Settings().group(ItemGroup.MATERIALS));;

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(FluidSieve.MOD_ID, "base"), BASE);
        Registry.register(Registry.ITEM, new Identifier(FluidSieve.MOD_ID, "net"), NET);
        Registry.register(Registry.ITEM, new Identifier(FluidSieve.MOD_ID, "dense_net"), DENSE_NET);
        Registry.register(Registry.ITEM, new Identifier(FluidSieve.MOD_ID, "mesh"), MESH);
        Registry.register(Registry.ITEM, new Identifier(FluidSieve.MOD_ID, "dense_mesh"), DENSE_MESH);
    }
}
