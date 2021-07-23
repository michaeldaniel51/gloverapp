package userapi.employer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userapi.employer.dtos.MusicDto;
import userapi.employer.models.Music;
import userapi.employer.services.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {


    @Autowired
    private MusicService musicService;

    @PostMapping
    public ResponseEntity<?> addMusic(@RequestBody Music music){
        return ResponseEntity.ok(musicService.AddMusic(music));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMusic(@PathVariable long id) {
        return ResponseEntity.ok(musicService.getMusicById(id));
    }


//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteMusic(@PathVariable long id){
//        return ResponseEntity.ok(musicService.deleteMusic(id));
//    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
         musicService.deleteById(id);
    }


    @GetMapping("/user")
    private ResponseEntity<?> getByUser (){
        return ResponseEntity.ok(musicService.getByUser());

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMusic(){
        return ResponseEntity.ok(musicService.getAllMusic());

    }

}
