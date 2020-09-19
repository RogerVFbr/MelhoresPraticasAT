package utils;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.teacher.aggregate.entity.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class MockGenerator {

    public static List<Teacher> getTeachers(int numberOfTeachers) {
        return IntStream
            .range(0, numberOfTeachers)
            .mapToObj(i ->
                Teacher.create(
                    (long) i,
                    "MockTeacherName" + 1,
                    "0881345461" + i,
                    LocalDateTime.now().minusYears(40),
                    new ArrayList<>()
                )
            )
            .collect(Collectors.toList());
    }

    public static List<Student> getStudents(int numberOfStudents) {
        return IntStream
            .range(0, numberOfStudents)
            .mapToObj(i ->
                Student.create(
                    (long) i,
                    "MockStudentName" + 1,
                    "0881345461" + i,
                    LocalDateTime.now().minusYears(20),
                    new ArrayList<>()
                )
            )
            .collect(Collectors.toList());
    }

    public static List<Subject> getSubjects(int numberOfSubjects,
                                            List<Teacher> teachers) {
        return IntStream
            .range(0, numberOfSubjects)
            .mapToObj(i ->
                Subject.create(
                    (long) i,
                    "MockSubjectName" + i,
                    "MockSubjectDescription" + 1,
                    teachers.get(i % teachers.size()),
                    StudyShift.forValue(i % StudyShift.values().length)
                )
            )
            .collect(Collectors.toList());
    }
}
