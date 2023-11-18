package ru.ahmetdavresh.MyRestSpringBootAppH2DB.service;

import org.springframework.stereotype.Service;
import ru.ahmetdavresh.MyRestSpringBootAppH2DB.entity.Course;
import java.util.List;
@Service
public interface CourseService {
    List<Course> getAllCourses();

    Course getCourse(int id);

    Course saveCourse(Course course);

    void deleteCourse(int id);
}
