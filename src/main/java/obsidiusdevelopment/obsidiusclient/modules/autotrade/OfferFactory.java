package obsidiusdevelopment.obsidiusclient.modules.autotrade;

import obsidiusdevelopment.obsidiusclient.modules.autotrade.offers.BaseOffer;
import obsidiusdevelopment.obsidiusclient.modules.autotrade.offers.IdOffer;
import obsidiusdevelopment.obsidiusclient.modules.autotrade.offers.ItemsOffer;

import java.util.HashMap;
import java.util.Map;

public class OfferFactory {
    private final Map<String, Factory> factories;

    public OfferFactory() {
        factories = new HashMap<>();
        factories.put(ItemsOffer.type, ItemsOffer::new);
        factories.put(IdOffer.type, IdOffer::new);
    }

    public BaseOffer createOffer(String name) {
        if (factories.containsKey(name)) return factories.get(name).create();
        return null;
    }

    private interface Factory {
        BaseOffer create();
    }
}
