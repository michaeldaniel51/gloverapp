package userapi.employer.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import userapi.employer.EmployerApplication;
import userapi.employer.models.Music;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EmployerApplication.class)
class MusicServiceTest {

    @Autowired
    private MusicService musicService;

    @Test
    void isOutdated() {

        Music music = new Music();

        music.setDateReleased(LocalDateTime.of(2021, Month.JUNE, 2, 12, 12, 12));

//        LocalDateTime testDate = LocalDateTime.of(2021, Month.NOVEMBER, 2, 12, 12, 12)

        Assertions.assertFalse(musicService.isOutdated(music));
    }
}