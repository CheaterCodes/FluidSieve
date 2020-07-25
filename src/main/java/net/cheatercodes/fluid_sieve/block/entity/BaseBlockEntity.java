package net.cheatercodes.fluid_sieve.block.entity;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class BaseBlockEntity extends LootableContainerBlockEntity implements Tickable {
    private LootContext lootContext;

    private DefaultedList<ItemStack> inventory;

    public BaseBlockEntity() {
        super(FluidSieveBlockEntityTypes.BASE);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.fluid_sieve.base");
    }

    @Override
    protected ScreenHandler createScreenHandler(int i, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, this);
    }

    @Override
    public int size() {
        return 9 * 3;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inventory);
        }

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);

        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.inventory);
        }
    }

    @Override
    public void tick() {
        if(!world.isClient) {
            generateItems();
        }
    }

    private void generateItems() {
        for(ItemStack stack : getLoot()) {
            insert(stack);
        }
    }

    private List<ItemStack> getLoot() {
        Block sourceBlock = world.getBlockState(pos.up()).getBlock();
        Identifier sourceID = Registry.BLOCK.getId(sourceBlock);
        Identifier lootTableID = new Identifier(sourceID.getNamespace(), "fluid_sieve/" + sourceID.getNamespace() + "/" + sourceID.getPath());
        LootTable lootTable = world.getServer().getLootManager().getTable(lootTableID);

        LootContextType.Builder typeBuilder = new LootContextType.Builder();
        typeBuilder.allow(LootContextParameters.POSITION);
        LootContextType type = typeBuilder.build();

        LootContext.Builder contextBuilder = new LootContext.Builder((ServerWorld)world);
        contextBuilder.parameter(LootContextParameters.POSITION, pos.up());
        this.lootContext = contextBuilder.build(type);

        return lootTable.generateLoot(lootContext);
    }

    private void insert(ItemStack stack) {
        if(stack.isStackable()) {
            for (int slotIndex = 0; slotIndex < size(); slotIndex++) {
                ItemStack slot = getStack(slotIndex);
                if (slot.getItem() == stack.getItem()) {
                    int maxStack = Math.min(slot.getMaxCount(), getMaxCountPerStack());
                    int amount = Math.min(maxStack - slot.getCount(), stack.getCount());
                    slot.increment(amount);
                    setStack(slotIndex, slot);
                    stack.decrement(amount);
                    if(stack.isEmpty()) {
                        return;
                    }
                }
            }
        }

        for(int slotIndex = 0; slotIndex < size(); slotIndex++) {
            ItemStack slot = getStack(slotIndex);
            if(slot.isEmpty()) {
                int maxStack = Math.min(slot.getMaxCount(), getMaxCountPerStack());
                int amount = Math.min(maxStack - slot.getCount(), stack.getCount());
                setStack(slotIndex, stack.split(amount));
                if(stack.isEmpty()) {
                    return;
                }
            }
        }
    }
}
