package com.demolearn.LearnSpringBoot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    private StudentRepository repository;
    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student){
        return repository.save(student);
    }

    @GetMapping("/student/findByEmail")
    public Student findStudent(@RequestParam("email") String email){
        return repository.findByEmail(email);
    }

    @PatchMapping("/student/updateStudent")
    public Student updateStudent(@RequestParam("student_id") String id, @RequestParam("new_email") String email){
    Optional<Student> student= repository.findById(id);
    if(student.isPresent())
    {
        Student studetobj= student.get();
        studetobj.setEmail(email);
        return repository.save(studetobj);
    }
    return null;
    }

    @GetMapping("/student/findByDomain")
    public List<Student> findByDomain(@RequestParam("domain") String domain)
    {
        return repository.findByDomain(domain);
    }
}
