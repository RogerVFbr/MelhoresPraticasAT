package com.soundlab.core.subject.aggregate.entity;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.exceptions.DuplicatedUserException;
import com.soundlab.exceptions.InexistentUserException;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class BelongingStudents {
    @Getter
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (students.contains(student))
            throw new DuplicatedUserException(student);

        students.add(student);
    }

    public void removeStudent(Student student) {
        checkStudentExistence(student);
        students.remove(student);
    }

    public void checkStudentExistence(Student student) {
        if (!students.contains(student))
            throw new InexistentUserException(student);
    }
}
