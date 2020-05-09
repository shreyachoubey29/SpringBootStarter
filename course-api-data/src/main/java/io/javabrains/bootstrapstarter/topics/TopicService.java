package io.javabrains.bootstrapstarter.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public List<topic> getAllTopics(){
		List<topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<topic> getTopic(String id) {
		return topicRepository.findById(id);
		
	}

	public void addTopic(topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(topic topic, String id) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		
		topicRepository.deleteById(id);	
	
	}
}
