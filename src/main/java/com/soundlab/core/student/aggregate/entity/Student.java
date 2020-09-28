package com.soundlab.core.student.aggregate.entity;

import com.soundlab.core.user.aggregate.entity.PhoneContact;
import com.soundlab.core.user.aggregate.entity.User;
import com.soundlab.core.user.aggregate.valueobject.BirthDate;
import com.soundlab.core.user.aggregate.valueobject.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Student extends User {

    private Student(Long id, String name, CPF cpf, BirthDate birthDate) {
        super(id, name, cpf, birthDate);
    }

    public static Student create(Long id, String name, String cpf, LocalDate birthDate) {
        CPF cpfObj = new CPF();
        cpfObj.setValue(cpf);
        BirthDate birthDateObj = new BirthDate();
        birthDateObj.setValue(birthDate);
        return new Student(id, name, cpfObj, birthDateObj);
    }

    public static Student create(Long id, String name, String cpf, LocalDate birthDate,
                                 List<PhoneContact> phoneContacts) {
        CPF cpfObj = new CPF();
        cpfObj.setValue(cpf);
        BirthDate birthDateObj = new BirthDate();
        birthDateObj.setValue(birthDate);
        Student student = new Student(id, name, cpfObj, birthDateObj);
        phoneContacts.forEach(student::addPhoneContact);
        return student;
    }
}
