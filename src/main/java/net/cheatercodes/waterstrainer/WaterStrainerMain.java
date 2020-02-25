package net.cheatercodes.waterstrainer;

import net.cheatercodes.waterstrainer.block.WaterStrainerBaseBlock;
import net.cheatercodes.waterstrainer.block.WaterStrainerNetBlock;
import net.cheatercodes.waterstrainer.block.entity.WaterStrainerBaseBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WaterStrainerMain implements ModInitializer {

	//Blocks
	public static final WaterStrainerBaseBlock WATER_STRAINER_BASE_BLOCK = new WaterStrainerBaseBlock();
	public static final WaterStrainerNetBlock WATER_STRAINER_NET_BLOCK = new WaterStrainerNetBlock();
	public static final WaterStrainerNetBlock DENSE_WATER_STRAINER_NET_BLOCK = new WaterStrainerNetBlock();

	//BlockEntities
	public static final BlockEntityType<WaterStrainerBaseBlockEntity> WATER_STRAINER_BASE_ENTITY = BlockEntityType.Builder.create(WaterStrainerBaseBlockEntity::new, WATER_STRAINER_BASE_BLOCK).build(null);

	//Items
	public static final Item WATER_STRAINER_BASE_ITEM = new BlockItem(WATER_STRAINER_BASE_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS));
	public static final Item WATER_STRAINER_NET_ITEM = new BlockItem(WATER_STRAINER_NET_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS));
	public static final Item DENSE_WATER_STRAINER_NET_ITEM = new BlockItem(DENSE_WATER_STRAINER_NET_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS));
	public static final Item NET_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item DENSE_NET_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {
		//Blocks
		Registry.register(Registry.BLOCK, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("waterstrainer", "water_strainer_net"), WATER_STRAINER_NET_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("waterstrainer", "dense_water_strainer_net"), DENSE_WATER_STRAINER_NET_BLOCK);

		//RenderLayer
		BlockRenderLayerMap.INSTANCE.putBlock(WATER_STRAINER_NET_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(DENSE_WATER_STRAINER_NET_BLOCK, RenderLayer.getCutout());

		//Block Entities
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_ENTITY);

		//Items
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_ITEM);
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "water_strainer_net"), WATER_STRAINER_NET_ITEM);
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "dense_water_strainer_net"), DENSE_WATER_STRAINER_NET_ITEM);
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "net"), NET_ITEM);
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "dense_net"), DENSE_NET_ITEM);
	}
}
