package com.soundlab.core.subject.aggregate.specification;

import com.soundlab.abstracts.specification.AbstractSpecification;
import com.soundlab.core.subject.aggregate.enums.StudyShift;

public class StudyShiftSpecification extends AbstractSpecification<StudyShift> {

    StudyShift shift;

    public StudyShiftSpecification(StudyShift shift) {
        this.shift = shift;
    }

    @Override
    public boolean isSatisfiedBy(StudyShift shift) {
        return this.shift == shift;
    }
}
