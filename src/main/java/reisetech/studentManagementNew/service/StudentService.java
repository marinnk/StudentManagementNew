package reisetech.studentManagementNew.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourse;
import reisetech.studentManagementNew.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    //検索処理
    List<Student> allStudents = repository.search();
    List<Student> filteredStudents = new ArrayList<>();
    //絞り込みをする。年齢が30代の人のみを抽出
    //抽出したリストトをコントローラーに返す
    for (Student student : allStudents){
      if(student.getAge()>=30 && 39 >= student.getAge()){
        filteredStudents.add(student);
      } }
    return filteredStudents;
  }

  public List<StudentCourse> searchStudentCourseList() {
    //絞り込み検索で「Javaコース」のコース情報のみ抽出する
    //抽出したリストをコントローラーに返す
    return repository.searchStudentCourse();
  }
}
