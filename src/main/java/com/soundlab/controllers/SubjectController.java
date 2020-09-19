package com.soundlab.controllers;

import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.services.SubjectService;

import java.util.List;

public class SubjectController {

    SubjectService subjectService = new SubjectService();

    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    public Subject getById(Long id) {
        return subjectService.getById(id);
    }

    public void save(Subject subject) {
        subjectService.save(subject);
    }

    public void delete(Long id) {
        subjectService.delete(id);
    }

    public void update(Long id, Subject subject) {
        subjectService.update(id, subject);
    }
}
