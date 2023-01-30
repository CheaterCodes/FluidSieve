package codes.cheater.fluid_sieve.block.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaseBlockEntity extends LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inventory;

    public BaseBlockEntity(BlockPos pos, BlockState state) {
        super(FluidSieveBlockEntityTypes.BASE, pos, state);
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
        return Text.translatable("container.fluid_sieve.base");
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
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory);
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory);
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, BaseBlockEntity blockEntity) {
        blockEntity.generateItems();
    }

    private void generateItems() {
        for (ItemStack stack : getLoot()) {
            insert(stack);
        }
    }

    private List<ItemStack> getLoot() {
        Block sourceBlock = world.getBlockState(pos.up()).getBlock();
        Identifier sourceID = Registries.BLOCK.getId(sourceBlock);
        Identifier lootTableID = new Identifier(sourceID.getNamespace(),
                "fluid_sieve/" + sourceID.getNamespace() + "/" + sourceID.getPath());
        LootTable lootTable = world.getServer().getLootManager().getTable(lootTableID);

        LootContextType.Builder typeBuilder = new LootContextType.Builder();
        typeBuilder.allow(LootContextParameters.ORIGIN);
        LootContextType type = typeBuilder.build();

        LootContext.Builder contextBuilder = new LootContext.Builder((ServerWorld) world);
        contextBuilder.parameter(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos.up()));
        LootContext lootContext = contextBuilder.build(type);

        return lootTable.generateLoot(lootContext);
    }

    private void insert(ItemStack stack) {
        if (stack.isStackable()) {
            for (int slotIndex = 0; slotIndex < size(); slotIndex++) {
                ItemStack slot = getStack(slotIndex);
                if (slot.getItem() == stack.getItem()) {
                    int maxStack = Math.min(slot.getMaxCount(), getMaxCountPerStack());
                    int amount = Math.min(maxStack - slot.getCount(), stack.getCount());
                    slot.increment(amount);
                    setStack(slotIndex, slot);
                    stack.decrement(amount);
                    if (stack.isEmpty()) {
                        return;
                    }
                }
            }
        }

        for (int slotIndex = 0; slotIndex < size(); slotIndex++) {
            ItemStack slot = getStack(slotIndex);
            if (slot.isEmpty()) {
                int maxStack = Math.min(slot.getMaxCount(), getMaxCountPerStack());
                int amount = Math.min(maxStack - slot.getCount(), stack.getCount());
                setStack(slotIndex, stack.split(amount));
                if (stack.isEmpty()) {
                    return;
                }
            }
        }
    }

}
