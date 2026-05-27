package reisetech.studentManagementNew.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourses> studentCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    for(Student student : students) {
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
}
