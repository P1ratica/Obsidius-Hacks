package obsidiusdevelopment.obsidiusclient.events;

public class DisconnectedScreenEvent {
    private static final DisconnectedScreenEvent INSTANCE = new DisconnectedScreenEvent();

    public static DisconnectedScreenEvent get() {
        return INSTANCE;
    }
}
