package lld.pubsubsystem;

public class PrintSubscriber implements ISubscriber {
    private final String name;

    PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber " + name + " received message: " + message.getContent());
    }
}