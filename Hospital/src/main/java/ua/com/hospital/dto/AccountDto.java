package ua.com.hospital.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ua.com.hospital.model.enums.Authority;
import ua.com.hospital.validator.PasswordMatches;
import ua.com.hospital.validator.ValueOfEnum;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@PasswordMatches
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Long id;
    @NotBlank
    @Size(min = 6, max = 16)
    private String username;
    @NotBlank
    @Size(min = 6, max = 16)
    @ToString.Exclude
    private String password;
    @NotBlank
    @Size(min = 6, max = 16)
    @ToString.Exclude
    private String repeatPassword;
    @NotBlank
    @Email
    private String email;
    @ValueOfEnum(enumClass = Authority.class)
    private String authority;
    @NotBlank
    @Size(min = 2)
    private String name;
    @NotBlank
    @Size(min = 2)
    private String surname;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthday;
}
