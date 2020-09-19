package com.soundlab.core.user.aggregate.valueobject;

import lombok.Data;
import com.soundlab.utils.StringFormatterUtil;

@Data
public class CPF {
    private String value;

    public String getFormatted() {
        return StringFormatterUtil.getFormatted(value, "###.###.###-##");
    }
}
