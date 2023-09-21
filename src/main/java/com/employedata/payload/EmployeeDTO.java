package com.employedata.payload;

import com.employedata.config.Numeric;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
public class EmployeeDTO {
    private String employeeId;

    @NotEmpty
    @Size(min=4 , max = 15, message = "First name should be in between 4 to 15 chars !!!")
    private String firstName;

    @NotEmpty
    @Size(min=4 , max = 15, message = "Last name should be in between 4 to 15 chars !!!")
    private String lastName;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "At least one phone number is required")
    private List<String> phoneNumbers;

    @NotBlank(message = "DOJ is mandatory")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format, should be yyyy-MM-dd")
    private String doj;

    @NotNull(message = "Salary is mandatory")
    @Numeric(message = "Salary must be a valid numeric value")
    private Double salary;
}