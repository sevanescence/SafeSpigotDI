package com.makotomiyamoto.ssdi.inventory;

import com.makotomiyamoto.ssdi.parser.GsonParsable;
import error.NativeStructBuildException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SafeItemStack implements GsonParsable {

    private Material material;
    private int amount;
    private transient int maxStackSize; // READ ONLY :)

    public SafeItemStack(Material material, int amount) {

        // todo search for native max stack size, read only

        this.material = material;
        this.amount = amount;

    }

    public Material getMaterial() {
        return material;
    }
    public int getAmount() {
        return amount;
    }
    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ItemStack build() throws NativeStructBuildException {

        if (material == null)
            throw new NativeStructBuildException("ItemStack Material returned null.");
        if (amount < 0)
            throw new NativeStructBuildException("ItemStack amount cannot be less than 0.");

        ItemStack itemStack = new ItemStack(material, amount);

        return itemStack;

    }

}
