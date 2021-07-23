package userapi.employer.services;


import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import userapi.employer.dtos.MusicDto;
import userapi.employer.exceptions.MusicNotOutDatedException;
import userapi.employer.models.Music;
import userapi.employer.models.User;
import userapi.employer.repositories.MusicRepository;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MusicService {




    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private SecurityService securityService;


    public Music AddMusic(Music music) {

        System.out.println(music);
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        music.setUser(securityService.authenticatedUser());
        return musicRepository.save(music);
    }

    public boolean isOutdated(Music music) {
        return !music.getDateReleased().plusMonths(4).isAfter(LocalDateTime.now());
//        return LocalDateTime.now().minusMonths(4).isBefore(music.getDateReleased());
    }

    public void deleteById(long musicId) {
        Music music = musicRepository.findById(musicId).orElseThrow();
        if (isOutdated(music)) {
            musicRepository.deleteById(music.getId());
        } else {
            throw new MusicNotOutDatedException("music is not outdated");
        }
    }


    public List<Music> getAllMusic(){
        List<Music> music = musicRepository.findAll().stream().collect(Collectors.toList());
        return music;
    }



    public List<Music> getByUser(){

        User user = securityService.authenticatedUser();

        return musicRepository.findByUser(user);

    }

    public Music getMusicById(long id) {
        return musicRepository.findById(id).orElseThrow();
    }
}