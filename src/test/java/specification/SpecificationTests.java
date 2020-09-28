package specification;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.teacher.aggregate.entity.Teacher;
import com.soundlab.repositories.SubjectRepository;

import org.junit.jupiter.api.Test;

import java.util.List;

import utils.MockGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecificationTests {

    @Test
    void whenSpecify() {
        List<Teacher> teachers = MockGenerator.getTeachers(1);
        List<Student> students = MockGenerator.getStudents(1);
        List<Subject> subjects = MockGenerator.getSubjects(6, teachers, students);

        SubjectRepository subjectRepository = new SubjectRepository();
        subjects.forEach(subjectRepository::save);

        List<Subject> eveningShiftSubjects = subjectRepository.getByShift(StudyShift.EVENING);

        assertEquals(eveningShiftSubjects.size(), 2);

        MockGenerator.printAsJson(eveningShiftSubjects);

    }
}
