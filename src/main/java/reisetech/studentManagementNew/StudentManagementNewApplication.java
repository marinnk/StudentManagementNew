package reisetech.studentManagementNew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	private List<Map<String, String>> students = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementNewApplication.class, args);
	}

	@GetMapping("/studentInfo")
	public String getstudentInfo() {
		return students.toString();
	}

	@PostMapping("/studentInfo")
	public void setstudentInfo(String name, String age) {
		Map<String, String> student = new HashMap<>();
		student.put("name", name);
		student.put("age", age);

		students.add(student);

	}

	@PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name;
	}


}
