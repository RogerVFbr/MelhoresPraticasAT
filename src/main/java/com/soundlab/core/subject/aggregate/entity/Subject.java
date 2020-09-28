package com.soundlab.core.subject.aggregate.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.teacher.aggregate.entity.Teacher;
import com.soundlab.exceptions.InvalidSubjectInstantiationException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public abstract class Subject {
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private Teacher teacher;
    @Getter @Setter private StudyShift studyShift;
    @Getter private final BelongingStudents students = new BelongingStudents();
    @Getter private final PresenceMap presenceMap = new PresenceMap();
    @Getter private final GradeMap gradeMap = new GradeMap();

    protected Subject() {};

    private Subject(Long id, String name, String description, Teacher teacher,
                    StudyShift studyShift) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.studyShift = studyShift;
    }

    public static <T extends Subject> T create(Class<T> type, Long id, String name, String description, Teacher teacher,
                          StudyShift studyShift) {
        try {
            T result = type.newInstance();
            result.setId(id);
            result.setName(name);
            result.setDescription(description);
            result.setStudyShift(studyShift);
            result.setTeacher(teacher);
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new InvalidSubjectInstantiationException();
        }
    }

    public static <T extends Subject> T create(Class<T> type, Long id, String name, String description, Teacher teacher,
                          StudyShift studyShift, Set<Student> students) {
        try {
            T result = type.newInstance();
            result.setId(id);
            result.setName(name);
            result.setDescription(description);
            result.setStudyShift(studyShift);
            result.setTeacher(teacher);
            students.forEach(result::addStudent);
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new InvalidSubjectInstantiationException();
        }
    }

    public abstract int getSubjectWeight();

    public abstract String getSubjectType();

    public void addStudent(Student student) {
        students.addStudent(student);
    }

    public void removeStudent(Student student) {
        students.removeStudent(student);
    }

    public void addPresence(LocalDate date, Student student) {
        students.checkStudentExistence(student);
        presenceMap.addPresence(date, student);
    }

    public void addGrade(Student student, Double grade) {
        students.checkStudentExistence(student);
        gradeMap.addGrade(student, grade);
    }

    public List<Double> getGradesByStudent(Student student) {
        students.checkStudentExistence(student);
        return gradeMap.getGradesByStudent(student);
    }

    public void updateGrade(Student student, int index, Double value) {
        students.checkStudentExistence(student);
        gradeMap.updateGrade(student, index, value);
    }

    public String getStudentAverage(Student student) {
        students.checkStudentExistence(student);
        return gradeMap.getStudentAverage(student);
    }
}