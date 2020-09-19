package com.soundlab.core.subject.aggregate.entity;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.exceptions.InexistentUserException;
import com.soundlab.exceptions.InvalidGradeIndexException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;

public class GradeMap {
    @Getter
    private final Map<Student, List<Double>> gradeMap = new HashMap<>();

    public void addGrade(Student student, Double grade) {
        if (!gradeMap.containsKey(student))
            gradeMap.put(student, new ArrayList<>());

        gradeMap.get(student).add(grade);
    }

    public List<Double> getGradesByStudent(Student student) {
        if (!gradeMap.containsKey(student))
            return new ArrayList<>();

        return gradeMap.get(student);
    }

    public void updateGrade(Student student, int gradeIndex, Double value) {
        if (!gradeMap.containsKey(student))
            throw new InexistentUserException(student);

        if (gradeMap.size() - 1 < gradeIndex || gradeIndex < 0)
            throw new InvalidGradeIndexException(gradeIndex);

        gradeMap.get(student).set(gradeIndex, value);
    }

    public String getStudentAverage(Student student) {
        if (!gradeMap.containsKey(student))
            throw new InexistentUserException(student);

        return gradeMap
            .get(student)
            .stream()
            .collect(Collectors.averagingDouble(Double::doubleValue))
            .toString();
    }

}
