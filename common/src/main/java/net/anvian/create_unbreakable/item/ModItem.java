package net.anvian.create_unbreakable.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.anvian.create_unbreakable.CreateUnbreakableToolsMod;
import net.anvian.create_unbreakable.item.custom.EternalItem;

public class ModItem {
    public static final CreateRegistrate REGISTRATE = CreateUnbreakableToolsMod.REGISTRATE;

    public static final ItemEntry<EternalItem> IRROMOLDING = REGISTRATE.item("irromolding",
            EternalItem::new).properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<EternalItem> PHILOLITE = REGISTRATE.item("philolite",
            EternalItem::new).register();

    public static final ItemEntry<EternalItem> LUMINARCHY = REGISTRATE.item("luminarchy",
            EternalItem::new).register();

    public static void init() {
        CreateUnbreakableToolsMod.LOGGER.info("Registering items for " + CreateUnbreakableToolsMod.NAME);
    }
}
