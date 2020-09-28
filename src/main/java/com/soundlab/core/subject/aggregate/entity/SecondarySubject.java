package com.soundlab.core.subject.aggregate.entity;

public class SecondarySubject extends Subject {
    public SecondarySubject() {
        super();
    }

    @Override
    public int getSubjectWeight() {
        return 10;
    }

    @Override
    public String getSubjectType() {
        return this.getClass().getSimpleName();
    }
}
