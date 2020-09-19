package com.soundlab.core.teacher.aggregate.entity;

import com.soundlab.core.user.aggregate.entity.PhoneContact;
import com.soundlab.core.user.aggregate.entity.User;
import com.soundlab.core.user.aggregate.valueobject.BirthDate;
import com.soundlab.core.user.aggregate.valueobject.CPF;

import java.time.LocalDateTime;
import java.util.List;

public class Teacher extends User {

    private Teacher(Long id, String name, CPF cpf, BirthDate birthDate) {
        super(id, name, cpf, birthDate);
    }

    public static Teacher create(Long id, String name, String cpf, LocalDateTime birthDate) {
        CPF cpfObj = new CPF();
        cpfObj.setValue(cpf);
        BirthDate birthDateObj = new BirthDate();
        birthDateObj.setValue(birthDate);
        return new Teacher(id, name, cpfObj, birthDateObj);
    }

    public static Teacher create(Long id, String name, String cpf, LocalDateTime birthDate,
                                 List<PhoneContact> phoneContacts) {
        CPF cpfObj = new CPF();
        cpfObj.setValue(cpf);
        BirthDate birthDateObj = new BirthDate();
        birthDateObj.setValue(birthDate);
        Teacher teacher = new Teacher(id, name, cpfObj, birthDateObj);
        phoneContacts.forEach(teacher::addPhoneContact);
        return teacher;
    }
}
