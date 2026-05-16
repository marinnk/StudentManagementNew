package reisetech.studentManagementNew.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentCourses> studentCourses;

}
