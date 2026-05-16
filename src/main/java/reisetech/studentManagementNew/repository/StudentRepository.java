package reisetech.studentManagementNew.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCourse();
}
