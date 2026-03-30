package com.rishi.dayseven.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    @NotBlank(message = "name should not be blank") //null + spaces
    @Size(min = 3 , max = 16 , message =  "The length of name should be >=3 and <=16")
    private String name;
    @Min(value = 1 , message = "Age should be greater then 1")
    @Max(value = 100 ,message = "Age should be less then 100")
    private int age;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter a valid Email")
    private String email;
}