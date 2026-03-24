package reisetech.studentManagementNew;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementNewApplication {

	@Autowired
	private StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(StudentManagementNewApplication.class, args);
	}

	@GetMapping("/student")
	public String getstudent() {
		List<Student> students = repository.getAllStudents();
		String result = "";
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			result += student.getName() + " " + student.getAge() + "歳";
		}
		return result;
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);
	}

	@PatchMapping("/student")
	public void updateStudentName(String name,int age) {
  	repository.updateStudent(name, age);
	}

	@DeleteMapping("/student")
	public void deleteStudent(String name) {
		repository.deleteStudent(name);
	}
}
