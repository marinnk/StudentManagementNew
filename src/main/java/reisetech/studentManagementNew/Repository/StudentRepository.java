package reisetech.studentManagementNew.Repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourse;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> searchByName();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchCourse();
}
