package reisetech.studentManagementNew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementNewApplication {

	@Autowired
	private StudentRepository repository;

	private String name = "Enami Koji";
	public String age = "32";

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementNewApplication.class, args);
	}

	@GetMapping("/student")
	public String getstudent(@RequestParam String name) {
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳";
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name;
	}
}
