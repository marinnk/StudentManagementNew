package reisetech.studentManagementNew.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCourse();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudentById(Integer id);

  @Select("SELECT * FROM students_courses WHERE student_id = #{id}")
  List<StudentCourses> searchStudentCourseById(Integer id);

  @Update("UPDATE students SET name = #{student.name}, furigana = #{student.furigana}, nickname = #{student.nickname}, mail = #{student.mail}, place = #{student.place}, age = #{student.age}, gender = #{student.gender}, remark = #{student.remark} WHERE id = #{student.id}")
  void updateStudent(StudentDetail studentDetail);

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

  @Insert("INSERT INTO students_courses (student_id,course_name,start,finish) VALUES (#{studentId},#{courseName},#{start},#{finish})")
  void registerStudentCourse(StudentCourses course);
}
