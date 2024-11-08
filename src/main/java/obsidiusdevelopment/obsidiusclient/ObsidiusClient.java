package obsidiusdevelopment.obsidiusclient;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.gui.renderer.GuiRenderer;
import meteordevelopment.meteorclient.gui.renderer.packer.GuiTexture;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import obsidiusdevelopment.obsidiusclient.modules.*;
import obsidiusdevelopment.obsidiusclient.hud.TextPresets;
import obsidiusdevelopment.obsidiusclient.modules.autotrade.AutoTrade;
import obsidiusdevelopment.obsidiusclient.utils.misc.ObsidiusClientStarscript;
import obsidiusdevelopment.obsidiusclient.settings.StringPairSetting;

public class ObsidiusClient extends MeteorAddon{
    public static final Logger LOG = LoggerFactory.getLogger("Obsidius.class");
    public static  final Category CATEGORY = new Category("Obsidius");
    public static final HudGroup HUD_GROUP = new HudGroup("Obsidius");
    public static String MOD_ID = "obsidius";

    public static GuiTexture ARROW_UP;
    public static GuiTexture ARROW_DOWN;
    public static GuiTexture COPY;
    public static GuiTexture EYE;

    @Override
    public void onInitialize() {
        LOG.info("Initializing Obsidius Client Addon");

        // Factories
        LOG.info("Registering custom factories...");
        StringPairSetting.register();

        // Modules
        LOG.info("Registering modules...");
        Modules.get().add(new AutoTrade());
        Modules.get().add(new AutoDrop());
        Modules.get().add(new BlockListMineCommand());
        Modules.get().add(new InstantBowKill());
        Modules.get().add(new InstaMineNuker());
        Modules.get().add(new ItemSucker());
        Modules.get().add(new ZAimbot());
        Modules.get().add(new ZKillaura());

        // Commands


        // HUD text presets
        LOG.info("Registering HUD text presets...");
        ObsidiusClientStarscript.init();
        Hud.get().register(TextPresets.INFO);

        // Icons
        ARROW_UP = GuiRenderer.addTexture(identifier("textures/icons/gui/arrow_up.png"));
        ARROW_DOWN = GuiRenderer.addTexture(identifier("textures/icons/gui/arrow_down.png"));
        COPY = GuiRenderer.addTexture(identifier("textures/icons/gui/copy.png"));
        EYE = GuiRenderer.addTexture(identifier("textures/icons/gui/eye.png"));
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    public String getPackage() {
        return getRepo().owner() + "." + getRepo().name();
    }

    public static Identifier identifier(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
