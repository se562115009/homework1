package camt.se494.course.config;

import camt.se494.course.entity.*;
import camt.se494.course.repository.CourseEnrolmentRepository;
import camt.se494.course.repository.CourseRepository;
import camt.se494.course.repository.OpenedCourseRepository;
import camt.se494.course.repository.StudentRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dto on 12/8/2015.
 */
@Component
public class DatabaseInitializationBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        initData();
    }

    @Autowired
    CourseEnrolmentRepository ceRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    OpenedCourseRepository openCourseRepo;

    @Autowired
    CourseRepository courseRepo;
    @Transactional
    private void initData() {
        //Create Student
        Student s1 = new Student("552115045", "Prayuth CanOcha");
        Student s2 = new Student("552115047", "Suthep Wongkamhang");
        Student s3 = new Student("552115048", "Surayuth Chulanon");
        Student s4 = new Student("552115049", "Taggy Chinosuke");
        Student s5 = new Student("552115022", "YingLove Chinosuke");
        studentRepo.save(s1);
        studentRepo.save(s2);
        studentRepo.save(s3);
        studentRepo.save(s4);
        studentRepo.save(s5);
        Course c1 = new Course("953494", "Special Topic in Software Engineering");
        Course c2 = new Course("953331", "Component Based Software Development");
        Course c3 = new Course("953201", "Introduction to Algorithm");
        Course c4 = new Course("953202", "Introduction to Software development");
        courseRepo.save(c1);
        courseRepo.save(c2);
        courseRepo.save(c3);
        courseRepo.save(c4);

        OpenedCourse oc11 = new OpenedCourse(c1, 2558);
        OpenedCourse oc12 = new OpenedCourse(c2, 2558);
        OpenedCourse oc13 = new OpenedCourse(c3, 2558);
        OpenedCourse oc14 = new OpenedCourse(c4, 2558);
        OpenedCourse oc21 = new OpenedCourse(c1, 2557);
        OpenedCourse oc22 = new OpenedCourse(c2, 2557);
        OpenedCourse oc23 = new OpenedCourse(c3, 2557);
        OpenedCourse oc24 = new OpenedCourse(c4, 2557);
        OpenedCourse oc31 = new OpenedCourse(c1, 2556);
        OpenedCourse oc32 = new OpenedCourse(c2, 2556);
        OpenedCourse oc33 = new OpenedCourse(c3, 2556);
        OpenedCourse oc34 = new OpenedCourse(c4, 2556);
        openCourseRepo.save(oc11);
        openCourseRepo.save(oc12);
        openCourseRepo.save(oc13);
        openCourseRepo.save(oc14);
        openCourseRepo.save(oc21);
        openCourseRepo.save(oc22);
        openCourseRepo.save(oc23);
        openCourseRepo.save(oc24);
        openCourseRepo.save(oc31);
        openCourseRepo.save(oc32);
        openCourseRepo.save(oc33);
        openCourseRepo.save(oc34);
        CourseEnrolment ce11 = new CourseEnrolment(s1, oc11, "B");
        CourseEnrolment ce12 = new CourseEnrolment(s1, oc22, "C");
        CourseEnrolment ce13 = new CourseEnrolment(s1, oc33, "D");
        CourseEnrolment ce14 = new CourseEnrolment(s1, oc34, "D+");
        ceRepo.save(ce11);
        ceRepo.save(ce12);
        ceRepo.save(ce13);
        ceRepo.save(ce14);
        CourseEnrolment ce21 = new CourseEnrolment(s2, oc21, "A");
        CourseEnrolment ce22 = new CourseEnrolment(s2, oc32, "B+");
        CourseEnrolment ce23 = new CourseEnrolment(s2, oc13, "C+");
        CourseEnrolment ce24 = new CourseEnrolment(s2, oc14, "A");
        ceRepo.save(ce21);
        ceRepo.save(ce22);
        ceRepo.save(ce23);
        ceRepo.save(ce24);
        CourseEnrolment ce31 = new CourseEnrolment(s3, oc31, "C+");
        CourseEnrolment ce32 = new CourseEnrolment(s3, oc22, "C+");
        CourseEnrolment ce33 = new CourseEnrolment(s3, oc33, "C+");
        CourseEnrolment ce34 = new CourseEnrolment(s3, oc34, "C+");
        ceRepo.save(ce31);
        ceRepo.save(ce32);
        ceRepo.save(ce33);
        ceRepo.save(ce34);
        CourseEnrolment ce41 = new CourseEnrolment(s4, oc11, "B+");
        CourseEnrolment ce42 = new CourseEnrolment(s4, oc12, "A");
        CourseEnrolment ce43 = new CourseEnrolment(s4, oc23, "F");
        CourseEnrolment ce44 = new CourseEnrolment(s4, oc24, "C");
        ceRepo.save(ce41);
        ceRepo.save(ce42);
        ceRepo.save(ce43);
        ceRepo.save(ce44);
        CourseEnrolment ce51 = new CourseEnrolment(s5, oc11, "B");
        CourseEnrolment ce52 = new CourseEnrolment(s5, oc12, "F");
        CourseEnrolment ce53 = new CourseEnrolment(s5, oc13, "F");
        CourseEnrolment ce54 = new CourseEnrolment(s5, oc14, "F");
        ceRepo.save(ce51);
        ceRepo.save(ce52);
        ceRepo.save(ce53);
        ceRepo.save(ce54);
    }
}
