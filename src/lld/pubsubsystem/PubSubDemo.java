package lld.pubsubsystem;

public class PubSubDemo {
    public static void main(String[] args) {
        Publisher pub1 = new Publisher();
        Publisher pub2 = new Publisher();

        Topic topic1 = new Topic("Topic1");
        Topic topic2 = new Topic("Topic2");

        Subscriber subscriber1 = new PrintSubscriber("Subscriber1");
        Subscriber subscriber2 = new PrintSubscriber("Subscriber2");
        Subscriber subscriber3 = new PrintSubscriber("Subscriber3");

        pub1.registerTopic(topic1);
        pub2.registerTopic(topic2);

        // Subscribe to topics
        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);

        // Publish messages
        pub1.publish(topic1, new Message("Message1 for Topic1"));
        pub1.publish(topic1, new Message("Message2 for Topic1"));
        pub2.publish(topic2, new Message("Message1 for Topic2"));


        // Unsubscribe from a topic
        topic1.removeSubscriber(subscriber2);

        // Publish more messages
        pub1.publish(topic1, new Message("Message3 for Topic1"));
        pub2.publish(topic2, new Message("Message2 for Topic2"));
    }
}