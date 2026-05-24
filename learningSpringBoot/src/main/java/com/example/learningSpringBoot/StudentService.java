//package com.example.learningSpringBoot;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class StudentService {
//    ArrayList<Student> students= new ArrayList<>();
//    public StudentService(){
//       students.add(new Student("Humkesh",20));
//        students.add(new Student("chotu",21));
//    }
//    public ArrayList<Student> getStudents(){
//        return students;
//    }
//    public void addStudent(Student s) {
//        students.add(s);
//    }
//
//}
package com.example.learningSpringBoot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addStudent(Student s) {
        repository.save(s);
    }
    public Student getStudentById(int id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found"));
    }
    public void deleteStudent(int id){

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        repository.delete(student);
    }
    public void updateStudent(int id, Student s){

        Student existing = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        existing.setName(s.getName());

        repository.save(existing);
    }
}
