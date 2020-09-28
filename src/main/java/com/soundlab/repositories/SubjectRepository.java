package com.soundlab.repositories;

import com.soundlab.abstracts.specification.Specification;
import com.soundlab.core.subject.aggregate.enums.StudyShift;
import com.soundlab.core.subject.aggregate.repository.ISubjectRepository;
import com.soundlab.core.subject.aggregate.entity.Subject;
import com.soundlab.core.subject.aggregate.specification.StudyShiftSpecification;
import com.soundlab.exceptions.DatabaseEntryAlreadyExistentException;
import com.soundlab.exceptions.DatabaseEntryInexistentException;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectRepository extends AbstractRepository<Subject> implements ISubjectRepository {

    @Override
    public List<Subject> getAll() {
        return repository;
    }

    @Override
    public Subject getById(Long id) {
        return repository.stream()
            .filter(subject -> subject.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public List<Subject> getByShift(StudyShift shift) {
        Specification<StudyShift> spec = new StudyShiftSpecification(shift);
        return repository.stream()
            .filter(subject -> spec.isSatisfiedBy(subject.getStudyShift()))
            .collect(Collectors.toList());
    }

    @Override
    public void save(Subject subject) {
        Subject subjectById = getById(subject.getId());

        if (subjectById != null)
            throw new DatabaseEntryAlreadyExistentException();

        repository.add(subject);
    }

    @Override
    public void delete(Long id) {
        Subject subjectById = getById(id);

        if (subjectById == null)
            throw new DatabaseEntryInexistentException();

        repository.remove(subjectById);
    }

    @Override
    public void update(Long id, Subject subject) {
        int index = repository.indexOf(subject);

        if (index == -1)
            throw new DatabaseEntryInexistentException();

        repository.set(index, subject);
    }
}
