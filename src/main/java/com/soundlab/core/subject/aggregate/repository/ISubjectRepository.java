package com.soundlab.core.subject.aggregate.repository;

import com.soundlab.core.subject.aggregate.entity.Subject;

import java.util.List;

public interface ISubjectRepository {
    List<Subject> getAll();
    Subject getById(Long id);
    void save(Subject subject);
    void delete(Long id);
    void update(Long id, Subject subject);
}
