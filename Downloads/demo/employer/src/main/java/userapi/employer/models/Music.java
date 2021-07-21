package userapi.employer.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.type.UUIDCharType;
import userapi.employer.enums.MusicGenre;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@Data
@Entity
@Table
public class Music {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "ALBUM")
    private String album;

    @Enumerated(EnumType.STRING)
    private MusicGenre genre;

    @Column(name = "DATE_RELEASED", updatable = false)
    private LocalDateTime dateReleased = LocalDateTime.now();

    @ManyToOne
    private User user;






}
