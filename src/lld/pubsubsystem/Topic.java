package lld.pubsubsystem;

import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    private final Set<ISubscriber> subscriberSet = new CopyOnWriteArraySet<>();

    Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<ISubscriber> getSubscriberSet() {
        return subscriberSet;
    }

    public void registerSubscriber(ISubscriber subscriber) {
        this.subscriberSet.add(subscriber);
    }

    public void removeSubscriber(ISubscriber subscriber) {
        this.subscriberSet.remove(subscriber);
    }

    public void publish(Message message) {
        for(ISubscriber subscriber: subscriberSet) {
            subscriber.onMessage(message);
        }
    }
}