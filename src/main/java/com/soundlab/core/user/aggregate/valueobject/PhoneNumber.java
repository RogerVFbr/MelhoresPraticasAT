package com.soundlab.core.user.aggregate.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.soundlab.utils.StringFormatterUtil;

@Data
@AllArgsConstructor
public class PhoneNumber {
    private String value;

    public String getFormatted() {
        return StringFormatterUtil.getFormatted(value, "(##) #####-####");
    }
}
