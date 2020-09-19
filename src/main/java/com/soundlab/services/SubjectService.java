package com.soundlab.services;

import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.repositories.SubjectRepository;

import java.util.List;

public class SubjectService {
    private SubjectRepository subjectRepository = new SubjectRepository();

    public List<Subject> getAll() {
        return subjectRepository.getAll();
    }

    public Subject getById(Long id) {
        return subjectRepository.getById(id);
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    public void delete(Long id) {
        subjectRepository.delete(id);
    }

    public void update(Long id, Subject subject) {
        subjectRepository.update(id, subject);
    }
}
