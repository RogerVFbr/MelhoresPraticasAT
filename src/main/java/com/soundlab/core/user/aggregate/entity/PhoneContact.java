package com.soundlab.core.user.aggregate.entity;

import com.soundlab.core.user.aggregate.enums.PhoneType;
import com.soundlab.core.user.aggregate.valueobject.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneContact {
    private Long id;
    private Long userId;
    private PhoneNumber number;
    private PhoneType type;
}
