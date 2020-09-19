package services;

import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.core.teacher.aggregate.entity.Teacher;
import com.soundlab.repositories.SubjectRepository;
import com.soundlab.services.SubjectService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import utils.MockGenerator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubjectServiceTests {

    @InjectMocks
    SubjectService subjectService;

    @Mock
    SubjectRepository subjectRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenGetAll_getSucceeds() {
        List<Teacher> teachers = MockGenerator.getTeachers(2);
        List<Subject> subjects = MockGenerator.getSubjects(2, teachers);

        Mockito.doReturn(subjects)
            .when(subjectRepository)
            .getAll();

        List<Subject> result = subjectService.getAll();

        assertEquals(subjects, result);
    }

    @Test
    void whenGetById_getSucceeds() {
        List<Teacher> teachers = MockGenerator.getTeachers(1);
        List<Subject> subjects = MockGenerator.getSubjects(1, teachers);

        Mockito.doReturn(subjects.get(0))
            .when(subjectRepository)
            .getById(Mockito.anyLong());

        Subject result = subjectService.getById(1L);

        assertEquals(subjects.get(0), result);
    }

    @Test
    void whenSave_andRepositorySaves_saveSucceeds() {
        List<Teacher> teachers = MockGenerator.getTeachers(1);
        List<Subject> subjects = MockGenerator.getSubjects(1, teachers);

        Mockito.doReturn(subjects.get(0))
            .when(subjectRepository)
            .getById(Mockito.anyLong());

        Subject result = subjectService.getById(1L);

        assertEquals(subjects.get(0), result);
    }

    @Test
    void whenSave_andRepositoryFails_saveThrowsException() {
        Mockito.doThrow(RuntimeException.class)
            .when(subjectRepository)
            .getById(Mockito.anyLong());

        assertThrows(RuntimeException.class, () -> subjectService.getById(1L));
    }

    @Test
    void whenDelete_andRepositoryDeletes_deleteSucceeds() {
        Mockito.doNothing()
            .when(subjectRepository)
            .delete(Mockito.anyLong());

        assertDoesNotThrow(() -> subjectService.delete(1L));
    }

    @Test
    void whenDelete_andRepositoryFails_deleteThrowsException() {
        Mockito.doThrow(RuntimeException.class)
            .when(subjectRepository)
            .delete(Mockito.anyLong());

        assertThrows(RuntimeException.class, () -> subjectService.delete(1L));
    }

    @Test
    void whenUpdate_andRepositoryUpdates_updateSucceeds() {
        List<Teacher> teachers = MockGenerator.getTeachers(1);
        List<Subject> subjects = MockGenerator.getSubjects(1, teachers);

        Mockito.doNothing()
            .when(subjectRepository)
            .update(Mockito.anyLong(), Mockito.any(Subject.class));

        assertDoesNotThrow(() -> subjectService.update(1L, subjects.get(0)));
    }

    @Test
    void whenUpdate_andRepositoryFails_updateThrowsException() {
        List<Teacher> teachers = MockGenerator.getTeachers(1);
        List<Subject> subjects = MockGenerator.getSubjects(1, teachers);

        Mockito.doThrow(RuntimeException.class)
            .when(subjectRepository)
            .update(Mockito.anyLong(), Mockito.any(Subject.class));

        assertThrows(RuntimeException.class, () -> subjectService.update(1L, subjects.get(0)));
    }
}
