package com.project.tacocloud.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Ma,e mist be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You mast choose at least 1 ingredient ")
    private List<Ingredient> ingredients;
}
