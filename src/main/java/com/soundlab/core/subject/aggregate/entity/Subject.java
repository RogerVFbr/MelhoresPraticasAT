package com.soundlab.core.subject.aggregate.entity;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.teacher.aggregate.entity.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Subject {
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private Teacher teacher;
    @Getter @Setter private StudyShift studyShift;
    @Getter private final BelongingStudents students = new BelongingStudents();
    @Getter private final PresenceMap presenceMap = new PresenceMap();
    @Getter private final GradeMap gradeMap = new GradeMap();

    private Subject() {};

    private Subject(Long id, String name, String description, Teacher teacher,
                    StudyShift studyShift) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.studyShift = studyShift;
    }

    public static Subject create(Long id, String name, String description, Teacher teacher,
                          StudyShift studyShift) {
        return new Subject(id, name, description, teacher, studyShift);
    }

    public static Subject create(Long id, String name, String description, Teacher teacher,
                          StudyShift studyShift, Set<Student> students) {
        Subject subject = new Subject(id, name, description, teacher, studyShift);
        students.forEach(subject::addStudent);
        return subject;
    }

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