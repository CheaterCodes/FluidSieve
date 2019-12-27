package net.cheatercodes.waterstrainer;

import net.cheatercodes.waterstrainer.block.WaterStrainerBaseBlock;
import net.cheatercodes.waterstrainer.block.entity.WaterStrainerBaseBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WaterStrainerMain implements ModInitializer {

	//Blocks
	public static final WaterStrainerBaseBlock WATER_STRAINER_BASE_BLOCK = new WaterStrainerBaseBlock();

	//BlockEntities
	public static final BlockEntityType<WaterStrainerBaseBlockEntity> WATER_STRAINER_BASE_ENTITY = BlockEntityType.Builder.create(WaterStrainerBaseBlockEntity::new, WATER_STRAINER_BASE_BLOCK).build(null);

	//Items
	public static final Item WATER_STRAINER_BASE_ITEM = new BlockItem(WATER_STRAINER_BASE_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS));

	@Override
	public void onInitialize() {
		//Blocks
		Registry.register(Registry.BLOCK, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_BLOCK);

		//Block Entities
		Registry.register(Registry.BLOCK_ENTITY, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_ENTITY);

		//Items
		Registry.register(Registry.ITEM, new Identifier("waterstrainer", "water_strainer_base"), WATER_STRAINER_BASE_ITEM);
	}
}
