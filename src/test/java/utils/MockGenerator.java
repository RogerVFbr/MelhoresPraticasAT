package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.core.subject.aggregate.entity.PrimarySubject;
import com.soundlab.core.subject.aggregate.entity.SecondarySubject;
import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.teacher.aggregate.entity.Teacher;
import com.soundlab.core.user.aggregate.entity.PhoneContact;
import com.soundlab.core.user.aggregate.entity.User;
import com.soundlab.core.user.aggregate.enums.PhoneType;
import com.soundlab.core.user.aggregate.valueobject.PhoneNumber;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class MockGenerator {

    private static final List<Class<? extends Subject>> subjects = Arrays.asList(PrimarySubject.class, SecondarySubject.class);

    public static List<Teacher> getTeachers(int numberOfTeachers) {
        return IntStream
            .range(0, numberOfTeachers)
            .mapToObj(i ->
                Teacher.create(
                    (long) i,
                    "MockTeacherName" + 1,
                    "0881345461" + i,
                    LocalDate.now()
                        .minusYears(new Random().nextInt(15) + 30)
                        .plusDays(new Random().nextInt(40) + 10),
                    IntStream
                        .range(0, new Random().nextInt(2) + 1)
                        .mapToObj(t -> getPhoneNumber(t, i))
                        .collect(Collectors.toList())
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
                    LocalDate.now()
                        .minusYears(new Random().nextInt(15) + 15)
                        .plusDays(new Random().nextInt(40) + 10),
                    IntStream
                        .range(0, new Random().nextInt(2) + 1)
                        .mapToObj(t -> getPhoneNumber(t, i))
                        .collect(Collectors.toList())
                )
            )
            .collect(Collectors.toList());
    }

    public static List<Subject> getSubjects(int numberOfSubjects,
                                            List<Teacher> teachers,
                                            List<Student> students) {
        return IntStream
            .range(0, numberOfSubjects)
            .mapToObj(i ->
                Subject.create(
                    subjects.get(i % subjects.size()),
                    (long) i,
                    "MockSubjectName" + i,
                    "MockSubjectDescription" + 1,
                    teachers.get(i % teachers.size()),
                    StudyShift.forValue(i % StudyShift.values().length),
                    new HashSet<>(students)
                )
            )
            .collect(Collectors.toList());
    }

    public static <T> void printAsJson(T data) {
        try {
            System.out.println(
                new ObjectMapper()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                    .registerModule(new JavaTimeModule())
                    .writeValueAsString(data)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PhoneContact getPhoneNumber(int id, int userId) {
        Random random = new Random();
        return new PhoneContact(
            (long) id,
            (long) userId,
            new PhoneNumber(
                IntStream
                    .range(0, 10)
                    .mapToObj(i -> String.valueOf(random.nextInt(9)))
                    .collect(Collectors.joining())
            ),
            PhoneType.forValue(random.nextInt(2) % PhoneType.values().length)
        );
    }
}
