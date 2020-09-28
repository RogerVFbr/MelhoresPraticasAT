package com.soundlab.core.subject.aggregate.entity;

import com.soundlab.core.student.aggregate.entity.Student;
import com.soundlab.exceptions.InvalidDateException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.ToString;

@ToString
public class PresenceMap {
    @Getter
    private final Map<LocalDate, Set<Student>> presenceMap = new HashMap<>();

    public void addPresence(LocalDate date, Student student) {
        if (date.isBefore(LocalDate.now()))
            throw new InvalidDateException(date);

        if (!presenceMap.containsKey(date))
            presenceMap.put(date, new HashSet<>());

        presenceMap.get(date).add(student);
    }
}
