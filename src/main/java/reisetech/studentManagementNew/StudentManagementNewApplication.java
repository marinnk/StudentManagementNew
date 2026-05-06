package reisetech.studentManagementNew;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reisetech.studentManagementNew.repository.StudentRepository;
import reisetech.studentManagementNew.data.Student;
import reisetech.studentManagementNew.data.StudentCourse;

@SpringBootApplication
@RestController
public class StudentManagementNewApplication {

	@Autowired
	private StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(StudentManagementNewApplication.class, args);
	}

	@GetMapping("/student")
	public List<Student> getStudentList() {
		return repository.searchByName();
	}

	@GetMapping("/studentCourse")
	public List<StudentCourse> getStudentCourseList() {
		return repository.searchCourse();
	}

}
