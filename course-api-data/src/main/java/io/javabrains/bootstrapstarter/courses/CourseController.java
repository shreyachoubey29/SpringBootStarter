package io.javabrains.bootstrapstarter.courses;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.bootstrapstarter.topics.topic;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> courses(@PathVariable String topicId) {
		
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new topic(topicId, "", ""));
		
		courseService.addCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId, String id) {
		course.setTopic(new topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void  deleteTopic(@PathVariable String topicId, @PathVariable String id) {
		
		courseService.deleteCourse(id);
	}
}
