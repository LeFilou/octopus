package org.melsif.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Department implements Serializable {
    private static final long serialVersionUID = 7546505191228324836L;

    private Integer id;
    private String name;
}
