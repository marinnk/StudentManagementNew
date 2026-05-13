package reisetech.studentManagementNew.service;

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
    repository.search();

    //絞り込みをする。年齢が30代の人のみを抽出
    //抽出したリストトをコントローラーに返す
    return repository.search();
  }

  public List<StudentCourse> searchStudentCourseList() {
    //絞り込み検索で「Javaコース」のコース情報のみ抽出する
    //抽出したリストをコントローラーに返す
    return repository.searchStudentCourse();
  }
}
