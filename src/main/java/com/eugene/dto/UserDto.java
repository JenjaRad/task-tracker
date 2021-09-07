package com.eugene.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class UserDto extends AbstractDto {

    @NotBlank(groups = {TaskViews.NewTask.class} , message = "username cannot be null or blank")
    @Size(min = 5 , max = 15 , message = "Username must be in range of 5 and 15 characters")
    @Pattern(regexp = "^[aA-zZ]\\w{4,14}$", message = "Please provide valid username")
    @JsonView({TaskViews.StandardView.class,TaskViews.DetailedView.class})
    private String username;

    @NotBlank(groups = {TaskViews.NewTask.class}, message = "First name cannot be null or empty")
    @Size(min = 2, max = 30)
    @JsonView({TaskViews.StandardView.class,TaskViews.DetailedView.class})
    private String firstName;

    @NotBlank(groups = {TaskViews.NewTask.class}, message = "Last name cannot be null or empty")
    @Size(min = 2, max = 30)
    @JsonView({TaskViews.StandardView.class,TaskViews.DetailedView.class})
    private String lastName;

    @NotBlank(groups = {TaskViews.NewTask.class}, message = "Last name cannot be null or empty")
    @Email(message = "Please provide a valid email")
    @JsonView({TaskViews.StandardView.class,TaskViews.DetailedView.class})
    private String email;

    @Builder
    public UserDto(Long id , String username, String firstName, String lastName, String email) {
        super.setId(id);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
