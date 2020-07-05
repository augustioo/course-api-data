package io.javabrains.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> getAllCourses(String topicId){
        //querys the database, finds all course instances and returns them
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    public Optional<Course> getCourse(String id){
        //way to iterate list and find specific item
        return courseRepository.findById(id);
    }
    public void addCourse(Course course){
        courseRepository.save(course);
        return;
    }
    public void updateCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
        return;
    }
}
