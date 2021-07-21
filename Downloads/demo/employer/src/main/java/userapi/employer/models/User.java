package userapi.employer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import userapi.employer.enums.Gender;
import userapi.employer.enums.MaritalStatus;
import userapi.employer.enums.MusicGenre;
import userapi.employer.models.Music;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME",length = 30)
    @NotNull(message = "username is required ")
    private String username;

    @Column(name = "PASSWORD",length = 20)
    @NotNull(message = "password is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email(message = "Malformed email")
    @NotNull(message = "email is required")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DATE_OF_BIRTH")
    @NotNull(message = "please enter your date of birth")
    private LocalDate dateOfBirth;

    @Column(name = "STATE_OF_ORIGIN")
    @NotNull(message = "please enter your state of origin")
    private String stateOfOrigin;

    @Column(name = "LGA_OF_RESIDENCE")
    @NotNull(message = "please enter your local government of residence")
    private String lgaOfResidence;

    @Column(name = "OCCUPATION")
    @NotNull(message = "please state your occupation")
    private String occupation;

    @Column(name = "MARITAL_STATUS")
    @NotNull(message = "Enter marital status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "PHONE_NUMBER")
    @NotNull(message = "Enter a valid phone number")
    private String phoneNumber;

    @Column(name = "GENDER")
    @NotNull(message = "Enter your specified gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user",orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Music> music = new ArrayList<>();


}
