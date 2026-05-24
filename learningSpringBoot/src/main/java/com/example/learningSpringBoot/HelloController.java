//package com.example.learningSpringBoot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//
//@RestController
//public class HelloController {
//    @Autowired
//    StudentService service;
//    @GetMapping("/students")
//    public ArrayList<Student> getStudent() {
//
//        return service.getStudents();
//    }
//    @PostMapping("/student")
//    public String addStudent(@RequestBody Student s){
//        System.out.println(s.getName());
//        System.out.println(s.getId());
//
//        return "Student Added";
//    }
//    @GetMapping("studentcount")
//    public int studentCount(){
//        return service.getStudents().size();
//    }
//    @PostMapping("addstudent")
//    public void addStudents(@RequestBody Student s){
//        service.addStudent(s);
//    }
//}
package com.example.learningSpringBoot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final StudentService service;

    public HelloController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return service.getStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student s) {

        service.addStudent(s);

        return "Student Added";
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        service.deleteStudent(id);

        return "Deleted Successfully";
    }
    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable int id,@RequestBody Student s){
         service.updateStudent(id,s);

    }
}