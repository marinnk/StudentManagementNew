package reisetech.studentManagementNew;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementNewApplication {

	private String name = "Enami Koji";
	public String age = "32";


	public static void main(String[] args) {
		SpringApplication.run(StudentManagementNewApplication.class, args);
	}

	@GetMapping("/studentInfo")
	public String getstudentInfo() {
		return name + " " + age + "歳";
	}

	@PostMapping("/studentInfo")
	public void setstudentInfo(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name;
	}


}
