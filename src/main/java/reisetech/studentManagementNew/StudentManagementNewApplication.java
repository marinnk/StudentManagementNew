package reisetech.studentManagementNew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/studentInfo")
	public String getstudentInfo() {
		Student student = repository.searchByName("Ramuda Amemura");
		return student.getName() + " " + student.getAge() + "歳";
	}

	@PostMapping("/studentInfo")
	public void setstudentInfo() {
		this.name = name;
		this.age = age;
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name;
	}
}
