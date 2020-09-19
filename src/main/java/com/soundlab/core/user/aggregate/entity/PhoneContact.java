package com.soundlab.core.user.aggregate.entity;

import com.soundlab.core.user.aggregate.enums.PhoneType;
import com.soundlab.core.user.aggregate.valueobject.PhoneNumber;
import lombok.Data;

@Data
public class PhoneContact {
    private Long id;
    private PhoneNumber number;
    private PhoneType type;
}
