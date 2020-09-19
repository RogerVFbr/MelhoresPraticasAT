package com.soundlab.core.user.aggregate.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.soundlab.core.user.aggregate.enums.PhoneType;
import com.soundlab.core.user.aggregate.valueobject.BirthDate;
import com.soundlab.core.user.aggregate.valueobject.CPF;
import com.soundlab.exceptions.TooManyContactsException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class User {
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private CPF cpf;
    @Getter @Setter private BirthDate birthDate;
    @Getter private final List<PhoneContact> phoneContacts = new ArrayList<>();

    protected User() {}

    protected User(Long id, String name, CPF cpf, BirthDate birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    protected User(Long id, String name, CPF cpf, BirthDate birthDate,
                   List<PhoneContact> phoneContacts) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        phoneContacts.forEach(this::addPhoneContact);
    }

    public void addPhoneContact(PhoneContact phoneContact) {
        if (phoneContacts.size() > 3) throw new TooManyContactsException();
        phoneContacts.add(phoneContact);
    }

    public List<PhoneContact> listPhoneContactsByType(PhoneType phoneType) {
        return phoneContacts.stream()
            .filter(phoneContact -> phoneContact.getType().equals(phoneType))
            .collect(Collectors.toList());
    }
}
