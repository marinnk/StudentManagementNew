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

  @Insert("""
    INSERT INTO students
    (name, furigana, nickname, mail, place, age, gender, remark, is_deleted)
    VALUES
    (#{student.name},
     #{student.furigana},
     #{student.nickname},
     #{student.mail},
     #{student.place},
     #{student.age},
     #{student.gender},
     #{student.remark},
     #{student.isDeleted})
    """)
  @Options(useGeneratedKeys = true, keyProperty = "student.id", keyColumn = "id")
  void registerStudent(StudentDetail studentDetail);

  @Insert("INSERT INTO students_courses (student_id,course_name,start) VALUES (#{studentId},#{courseName},#{start})")
  void registerStudentCourse(StudentCourses course);
}
