package net.cheatercodes.fluid_sieve.item;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidSieveItems {
    public static FluidSieveItems INSTANCE = new FluidSieveItems();

    public final BlockItem BASE;
    public final BlockItem NET;
    public final BlockItem DENSE_NET;

    public final Item MESH;
    public final Item DENSE_MESH;

    private FluidSieveItems() {
        BASE = register(FluidSieve.BLOCKS.BASE, ItemGroup.DECORATIONS);
        NET = register(FluidSieve.BLOCKS.NET, ItemGroup.DECORATIONS);
        DENSE_NET = register(FluidSieve.BLOCKS.DENSE_NET, ItemGroup.DECORATIONS);

        MESH = register("mesh", ItemGroup.MATERIALS);
        DENSE_MESH = register("dense_mesh", ItemGroup.MATERIALS);
    }

    private static BlockItem register(Block block, ItemGroup group) {
        Identifier id = Registry.BLOCK.getId(block);
        return Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(group)));
    }

    private static Item register(String name, ItemGroup group) {
        return register(name, new Item(new Item.Settings().group(group)));
    }

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(FluidSieve.ID, name), item);
    }
}
