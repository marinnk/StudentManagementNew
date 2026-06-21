package reisetech.studentManagementNew.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentCourses {
    private Integer id;
    private Integer studentId;
    private String courseName;
    private LocalDateTime start;
    private LocalDateTime finish;

}
