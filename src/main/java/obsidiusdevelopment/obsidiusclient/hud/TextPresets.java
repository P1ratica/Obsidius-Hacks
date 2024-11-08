package obsidiusdevelopment.obsidiusclient.hud;

import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.elements.TextHud;
import obsidiusdevelopment.obsidiusclient.ObsidiusClient;

public class TextPresets {
    public static final HudElementInfo<TextHud> INFO = new HudElementInfo<>(ObsidiusClient.HUD_GROUP, "obsidius", "Additional presets for Meteor.", TextPresets::create);

    static {
        addPreset("Fall Distance", "Fall distance: #1{round(obsidiusclient.fall_distance, 1)}");
        addPreset("Max Fall Distance", "Max fall distance: #1{round(obsidiusclient.max_fall_distance, 1)}");
        addPreset("Fall Damage", "Fall damage: #1{round(obsidiusclient.fall_damage) / 2} ❤");
        addPreset("Max Fall Damage", "Max fall damage: #1{round(obsidiusclient.max_fall_damage) / 2} ❤");
    }

    private static TextHud create() {
        return new TextHud(INFO);
    }

    private static void addPreset(String title, String text) {
        INFO.addPreset(title, textHud -> {
            if (text != null) textHud.text.set(text);
            textHud.updateDelay.set(0);
        });
    }
}
