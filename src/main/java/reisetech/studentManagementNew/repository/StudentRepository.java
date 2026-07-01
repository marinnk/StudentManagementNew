package reisetech.studentManagementNew.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCourse();

  @Insert("INSERT INTO students (name) VALUES (#{student.name})")
  @Options(useGeneratedKeys = true, keyProperty = "student.id", keyColumn = "id")
  void registerStudent(StudentDetail studentDetail);

  @Insert("INSERT INTO students_courses (student_id,course_name) VALUES (#{student.id},#{studentCourses[0].courseName})")
  void registerStudentCourse(StudentDetail studentDetail);
}
