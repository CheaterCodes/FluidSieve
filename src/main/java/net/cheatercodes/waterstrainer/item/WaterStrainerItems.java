package net.cheatercodes.waterstrainer.item;

import net.cheatercodes.waterstrainer.WaterStrainer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WaterStrainerItems {
    public static WaterStrainerItems INSTANCE = new WaterStrainerItems();

    public final BlockItem WATER_STRAINER_BASE;
    public final BlockItem WATER_STRAINER_NET;
    public final BlockItem DENSE_WATER_STRAINER_NET;

    public final Item NET;
    public final Item DENSE_NET;

    private WaterStrainerItems() {
        WATER_STRAINER_BASE = register(WaterStrainer.BLOCKS.WATER_STRAINER_BASE, ItemGroup.DECORATIONS);
        WATER_STRAINER_NET = register(WaterStrainer.BLOCKS.WATER_STRAINER_NET, ItemGroup.DECORATIONS);
        DENSE_WATER_STRAINER_NET = register(WaterStrainer.BLOCKS.DENSE_WATER_STRAINER_NET, ItemGroup.DECORATIONS);

        NET = register("net", ItemGroup.MATERIALS);
        DENSE_NET = register("dense_net", ItemGroup.MATERIALS);
    }

    private static BlockItem register(Block block, ItemGroup group) {
        Identifier id = Registry.BLOCK.getId(block);
        return Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(group)));
    }

    private static Item register(String name, ItemGroup group) {
        return register(name, new Item(new Item.Settings().group(group)));
    }

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(WaterStrainer.ID, name), item);
    }
}
