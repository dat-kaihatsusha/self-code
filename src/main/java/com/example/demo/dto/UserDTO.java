package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  private String name;

  @Email(message = "email is not valid")
  private String email;

  @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$", message = "Phone not valid!")
  private String phone;
}
