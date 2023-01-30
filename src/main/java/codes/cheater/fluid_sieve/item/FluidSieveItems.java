package codes.cheater.fluid_sieve.item;

import codes.cheater.fluid_sieve.FluidSieve;
import codes.cheater.fluid_sieve.block.FluidSieveBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FluidSieveItems {
    public static final BlockItem BASE = new BlockItem(FluidSieveBlocks.BASE, new Item.Settings());
    public static final BlockItem NET = new BlockItem(FluidSieveBlocks.NET, new Item.Settings());
    public static final BlockItem DENSE_NET = new BlockItem(FluidSieveBlocks.DENSE_NET, new Item.Settings());

    public static final Item MESH = new Item(new Item.Settings());
    public static final Item DENSE_MESH = new Item(new Item.Settings());
    ;

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(FluidSieve.MOD_ID, "base"), BASE);
        Registry.register(Registries.ITEM, new Identifier(FluidSieve.MOD_ID, "net"), NET);
        Registry.register(Registries.ITEM, new Identifier(FluidSieve.MOD_ID, "dense_net"), DENSE_NET);
        Registry.register(Registries.ITEM, new Identifier(FluidSieve.MOD_ID, "mesh"), MESH);
        Registry.register(Registries.ITEM, new Identifier(FluidSieve.MOD_ID, "dense_mesh"), DENSE_MESH);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addItem(BASE);
            entries.addItem(NET);
            entries.addItem(DENSE_NET);
        });


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addItem(MESH);
            entries.addItem(DENSE_MESH);
        });
    }
}
