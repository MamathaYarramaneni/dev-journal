package lld.pubsubsystem;

public class Publisher {
    private Set<Topic> topicSet;

    Publisher() {
        this.topicSet = new HashSet<>();
    }

    public void registerTopic(Topic topic) {
        topicSet.add(topic);
    }

    public void publish(Topic topic, Message message) {
        if(!topicSet.contains(topic)) throw ResourceNotFoundException("Topic not found!");
        topic.publish(message);
    }
}