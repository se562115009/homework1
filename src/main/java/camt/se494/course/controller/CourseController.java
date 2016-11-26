package camt.se494.course.controller;

import camt.se494.course.entity.Course;
import camt.se494.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dto on 12/9/2015.
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getCourse(@RequestParam("query") String query) {
        return courseService.getCourseFromIdOrName(query);
    }


}
