package com.learnjava.CustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
