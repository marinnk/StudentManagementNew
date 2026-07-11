package reisetech.studentManagementNew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reisetech.studentManagementNew.controller.converter.StudentConverter;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourses;
import reisetech.studentManagementNew.domain.StudentDetail;
import reisetech.studentManagementNew.repository.StudentRepository;
import reisetech.studentManagementNew.service.StudentService;
import org.springframework.ui.Model;

@Controller
public class StudentController {

  private final StudentRepository studentRepository;
  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter,
      StudentRepository studentRepository) {
    this.service = service;
    this.converter = converter;
    this.studentRepository = studentRepository;
  }


  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCourseList();

    model.addAttribute("studentList", converter.convertStudentDetails(students, studentCourses));
    return "studentList";
  }

  @GetMapping("/student/{id}")
  public String updateStudent(@PathVariable Integer id, Model model) {
    model.addAttribute("studentDetail", service.getStudentDetail(id));
    return "updateStudent";
  }


  @GetMapping("/studentCourseList")
  public List<StudentCourses> getStudentCourseList() {
    return service.searchStudentCourseList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetail", new StudentDetail());
    return "registerStudent";
  }

  @PostMapping("/updateStudent")
  public String updateStudent(@ModelAttribute StudentDetail studentDetail) {
    service.updateStudent(studentDetail);
    return "redirect:/studentList";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {

    if(result.hasErrors()) {
      return "registerStudent";
    }
// 新規受講生情報を登録する処理を実装する。
    service.registerStudent(studentDetail);

// コース情報も一緒に登録できるように実装する。コース単体でいい。
    return "redirect:/studentList";
  }

}
