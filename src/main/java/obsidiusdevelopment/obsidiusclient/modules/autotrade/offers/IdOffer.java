package obsidiusdevelopment.obsidiusclient.modules.autotrade.offers;

import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;

public class IdOffer extends BaseOffer {
    public static final String type = "ID";
    SettingGroup sgId = settings.createGroup("ID");

    public final Setting<Integer> offerId = sgId.add(new IntSetting.Builder()
        .name("offer-id")
        .description("ID of offer to select.")
        .defaultValue(0)
        .min(0)
        .onChanged(value -> reloadParent())
        .build()
    );

    public IdOffer() {
    }

    public String getTypeName() {
        return type;
    }

    public IdOffer copy() {
        IdOffer copy = new IdOffer();
        copy.enabled.set(enabled.get());
        copy.offerId.set(offerId.get());
        return copy;
    }
}
