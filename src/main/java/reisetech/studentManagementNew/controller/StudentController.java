package reisetech.studentManagementNew.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;
import reisetech.studentManagementNew.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private List<Student> students;
  private List<StudentCourses> studentCourses;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }


  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCourseList();

    List<StudentDetail> studentDetails = new ArrayList<>();
    for(Student student :students) {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentCourses> convertStudentCourse = new ArrayList<>();
      for (StudentCourses studentCourse : studentCourses) {
        if(student.getId().equals(studentCourse.getStudentId())) {
          convertStudentCourse.add(studentCourse);
        }
      }
    studentDetail.setStudentCourses(convertStudentCourse);
    studentDetails.add(studentDetail);
    }
    return studentDetails;
  }

  @GetMapping("/studentCourseList")
  public List<StudentCourses> getStudentCourseList() {
    return service.searchStudentCourseList();
  }

}
