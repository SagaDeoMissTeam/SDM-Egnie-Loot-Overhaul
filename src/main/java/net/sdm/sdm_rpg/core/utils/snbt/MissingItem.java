package net.sdm.sdm_rpg.core.utils.snbt;

import dev.ftb.mods.ftblibrary.snbt.SNBTCompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MissingItem extends Item {

    private static final ResourceLocation AIR = new ResourceLocation("minecraft:air");

    public static ItemStack readItem(CompoundTag tag) {
        if (tag.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            ResourceLocation id = new ResourceLocation(tag.getString("id"));
            if (id.equals(AIR)) {
                return ItemStack.EMPTY;
            } else {
                Item item = (Item) ForgeRegistries.ITEMS.getValue(id);
                if (item == Items.AIR) {
                    ItemStack stack = new ItemStack(ItemStack.EMPTY.getItem());
                    stack.addTagElement("Item", tag);
                    return stack;
                } else {
                    return ItemStack.of(tag);
                }
            }
        }
    }

    public static CompoundTag writeItem(ItemStack stack) {
        if (stack.getItem() instanceof MissingItem && stack.hasTag() && stack.getTag().contains("Item")) {
            return stack.getTag().getCompound("Item");
        } else {
            SNBTCompoundTag tag = new SNBTCompoundTag();
            stack.save(tag);
            if (tag.size() == 2) {
                tag.singleLine();
            }

            return tag;
        }
    }

    public MissingItem() {
        super((new Item.Properties()).stacksTo(1));
    }

    public Component getName(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains("Item")) {
            CompoundTag tag = stack.getTag().getCompound("Item");
            String id = tag.getString("id");
            int c = Math.max(1, tag.getInt("Count"));
            return c == 1 ? Component.literal(id) : Component.literal("" + c + "x " + id);
        } else {
            return super.getName(stack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (stack.hasTag() && stack.getTag().contains("Item")) {
            tooltip.add(Component.translatable("item.ftbquests.missing_item").withStyle(ChatFormatting.RED));
        }

    }
}
