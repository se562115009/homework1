package camt.se494.course.service;

import camt.se494.course.dao.CourseEnrolmentDao;
import camt.se494.course.entity.CourseEnrolment;
import camt.se494.course.entity.Student;
import camt.se494.course.entity.StudentReport;
import camt.se494.course.service.util.GradeMatcher;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.number.IsCloseTo.*;
/**
 * Created by Dto on 10/2/2015.
 */
public class StudentServiceImplTest {
    @Test
    public void testGetStudentReport(){
        StudentServiceImpl studentService = spy(StudentServiceImpl.class);
        CourseEnrolmentDao courseEnrolmentDao = mock(CourseEnrolmentDao.class);
        List<CourseEnrolment> courseEnrolments = new ArrayList<>();
        studentService.setCourseEnrolmentDao(courseEnrolmentDao);
        when(studentService.getRegisterYear(courseEnrolments)).thenReturn(Arrays.asList(2554,2555,2556));
        Student student = new Student();
        StudentReport studentReport = new StudentReport();
        assertThat(studentService.getStudentReport(student),is(studentReport));
    }

    @Test
    public void testGetStudentGpa(){
        Student testStudent = mock(Student.class);
        List<CourseEnrolment> enrolmentsList = new ArrayList<>();
        CourseEnrolment courseEnrolment0 = mock(CourseEnrolment.class);
        when(courseEnrolment0.getGrade()).thenReturn("A");
        enrolmentsList.add(courseEnrolment0);
        CourseEnrolment courseEnrolment1 = mock(CourseEnrolment.class);
        when(courseEnrolment1.getGrade()).thenReturn("B");
        enrolmentsList.add(courseEnrolment1);
        CourseEnrolment courseEnrolment2 = mock(CourseEnrolment.class);
        when(courseEnrolment2.getGrade()).thenReturn("C");
        enrolmentsList.add(courseEnrolment2);
        when(testStudent.getCourseEnrolments()).thenReturn(enrolmentsList);

        GradeMatcher gradeMatcher = mock(GradeMatcher.class);
        when(gradeMatcher.getGradeScore("A")).thenReturn(4.00);
        when(gradeMatcher.getGradeScore("B")).thenReturn(3.00);
        when(gradeMatcher.getGradeScore("C")).thenReturn(2.00);

        // run the test
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setGradeMatcher(gradeMatcher);
        assertThat(studentService.getStudentGpa(testStudent),is(closeTo(3.00,0.001)));

        // verify that the grade matcher has been called
        verify(courseEnrolment0).getGrade();
        verify(courseEnrolment1).getGrade();

        // has it receive what should be?
        verify(gradeMatcher).getGradeScore("A");
        verify(gradeMatcher).getGradeScore("B");


        // verify how many times it has been called
        verify(courseEnrolment0,times(1)).getGrade();
        verify(gradeMatcher,times(3)).getGradeScore(anyString());
        verify(gradeMatcher,atLeast(2)).getGradeScore(anyString());

        //Check the order
        // set up the inorder verification
        InOrder inOrder = inOrder(courseEnrolment0,courseEnrolment1,courseEnrolment2,gradeMatcher);
        inOrder.verify(courseEnrolment0).getGrade();
        inOrder.verify(gradeMatcher).getGradeScore("A");
        inOrder.verify(courseEnrolment1).getGrade();
        inOrder.verify(gradeMatcher).getGradeScore("B");



    }
}
