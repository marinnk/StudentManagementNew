package reisetech.studentManagementNew.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;
import reisetech.studentManagementNew.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<StudentCourses> searchStudentCourseList() {
    return repository.searchStudentCourse();
  }
  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail);
    for(StudentCourses course : studentDetail.getStudentCourses()) {
      course.setStudentId(studentDetail.getStudent().getId());
      course.setStart(LocalDateTime.now());

      repository.registerStudentCourse(course);
    }
  }

}
