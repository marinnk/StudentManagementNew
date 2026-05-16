package reisetech.studentManagementNew.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentCourses {
    private String id;
    private String studentId;
    private String CourseName;
    private LocalDateTime start;
    private LocalDateTime end;

}
