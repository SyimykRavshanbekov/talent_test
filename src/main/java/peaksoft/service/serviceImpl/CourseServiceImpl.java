package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Long id) {
        return courseRepository.getAllCourses(id);
    }

    @Override
    public void addCourse(Long id, Course course) throws IOException {
        if (course.getCourseName().length()>3 && course.getDescription().length()>5 && course.getDescription().length()<15 && course.getDuration()>0 && course.getDuration()<24){
            for (Character i: course.getCourseName().toCharArray()) {
                if (!Character.isLetter(i)){
                    throw new IOException("В название курса нельзя вставлять цифры");
                }
            }
        }else {
            throw new IOException("Form error course registration");
        }
        courseRepository.addCourse(id,course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course, Long id) throws IOException {
        if (course.getCourseName().length()>3 && course.getDescription().length()>5 && course.getDescription().length()<15 && course.getDuration()>0 && course.getDuration()<24){
            for (Character i: course.getCourseName().toCharArray()) {
                if (!Character.isLetter(i)){
                    throw new IOException("В название курса нельзя вставлять цифры");
                }
            }
        }else {
            throw new IOException("Form error course registration");
        }
        courseRepository.updateCourse(course,id);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }
}
