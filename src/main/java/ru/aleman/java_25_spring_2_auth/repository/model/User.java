package ru.aleman.java_25_spring_2_auth.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

public class User {
    @JsonProperty("user")
    @NotBlank(message = "Имя пользователя не может быть пустое")
    @Size(min = 2, max = 20, message = "Длина пользователя от 2-х до 20-ти символов")
    private String user_name;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 2, max = 20, message = "Длина пароля от 2-х до 20-ти символов")
    private String password;

    public String getUser() {
        return user_name;
    }
    public void setUser(String user) {
        this.user_name = user;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
