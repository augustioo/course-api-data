package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    
    public List<Topic> getAllTopics(){
        //querys the database, finds all topic instances and returns them
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
    public Optional<Topic> getTopic(String id){
        //way to iterate list and find specific item
        return topicRepository.findById(id);
    }
    public void addTopic(Topic topic){
        topicRepository.save(topic);
        return;
    }
    public void updateTopic(Topic topic,String id){
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
        return;
    }
}
