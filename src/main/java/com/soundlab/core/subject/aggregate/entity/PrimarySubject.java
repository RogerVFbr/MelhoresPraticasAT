package com.soundlab.core.subject.aggregate.entity;

public class PrimarySubject extends Subject {
    public PrimarySubject() {
        super();
    }

    @Override
    public int getSubjectWeight() {
        return 20;
    }

    @Override
    public String getSubjectType() {
        return this.getClass().getSimpleName();
    }
}
