package PubSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageBroker {
    private Map<String, List<Subscriber>> topicSubscribers;
    public MessageBroker(){
        this.topicSubscribers= new HashMap<>();
    }
    void subscribe(String topic,Subscriber subscriber){
        topicSubscribers.computeIfAbsent(topic,k-> new ArrayList<>()).add(subscriber);
    }
    void unSubscribe(String topic,Subscriber subscriber){
        if(topicSubscribers.containsKey(topic)){
            topicSubscribers.get(topic).remove(subscriber);
        }
    }
    void notifySubscribers(String topic,Message message){
        if(topicSubscribers.containsKey(topic)){
            for(Subscriber s:topicSubscribers.get(topic)){
                s.update(message);
            }
        }
    }
}
