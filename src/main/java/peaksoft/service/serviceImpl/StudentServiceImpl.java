package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository service;

    @Autowired
    public StudentServiceImpl(StudentRepository service) {
        this.service = service;
    }

    @Override
    public List<Student> getAllStudents(Long id) {
        return service.getAllStudents(id);
    }

    @Override
    public void addStudent(Long id, Student student) {
        service.addStudent(id,student);
    }

    @Override
    public Student getStudentById(Long id) {
        return service.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        service.updateStudent(student,id);
    }

    @Override
    public void deleteStudent(Long id) {
        service.deleteStudent(id);
    }

    @Override
    public void assignStudent(Long groupId, Long studentId) {
        service.assignStudent(groupId,studentId);
    }
}
