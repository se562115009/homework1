package camt.se494.course.controller;

import camt.se494.course.entity.Course;
import camt.se494.course.entity.Student;
import camt.se494.course.service.CourseService;
import camt.se494.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 12/10/2015.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudent(@RequestParam("query") String query) {
        return studentService.getStudent(query);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public Student edit(@PathVariable("id") Long id, @RequestBody Student student, BindingResult bindingResult){
        return studentService.updateStudent(student);
    }
    @RequestMapping(method = RequestMethod.GET,value="/gradehigherthan")
    public List<Student> getStudentGradeHigerThan(@RequestParam("value") String query) {
        if (query.equals("")){
            query="0";
        }
        return studentService.getStudentGradeGreaterThan(Double.parseDouble(query));
    }

}
