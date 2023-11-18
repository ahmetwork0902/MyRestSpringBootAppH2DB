package ru.ahmetdavresh.MyRestSpringBootAppH2DB.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ahmetdavresh.MyRestSpringBootAppH2DB.entity.Course;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Slf4j
@Repository
public class CourseDAOImpl implements CourseDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Course> getAllCourses() {
        Query query = entityManager.createQuery("from Course");
        return query.getResultList();
    }

    @Override
    public Course saveCourse(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public Course getCourse(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Query query = entityManager.createQuery("delete from Course where id = :courseId");
        query.setParameter("courseId", id);
        query.executeUpdate();
    }
}
