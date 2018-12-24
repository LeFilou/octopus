package org.melsif.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Employee implements Serializable {
    private static final long serialVersionUID = -8801835552371684246L;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Function function;
    private Department department;
}
