package com.project.tacocloud.model;

import lombok.Data;

@Data
public class Taco {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type


}
