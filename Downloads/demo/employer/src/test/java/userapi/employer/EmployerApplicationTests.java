package userapi.employer;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import userapi.employer.models.Music;
import userapi.employer.models.User;
import userapi.employer.repositories.MusicRepository;
import userapi.employer.repositories.UserRepository;
import userapi.employer.services.SecurityService;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static userapi.employer.enums.MusicGenre.ROCK;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployerApplicationTests {

	@Autowired
	 private MusicRepository musicRepository;

	@Autowired
    private SecurityService securityService;

	@Test
	@Order(1)
	public void testCreate(){
		Music music = new Music();
		music.setId(4);
		music.setName("bad");
		music.setAlbum("follow me");
		music.setDateReleased(LocalDateTime.now());
		music.setGenre(ROCK);
		musicRepository.save(music);
		assertNotNull(musicRepository.findById((long)4).get());

	}
		@Test
        @Order(2)
	    public void testReadAll(){
		List<Music> music = musicRepository.findAll();
		assertThat(music).size().isGreaterThan(0);


	}

			@Test
			@Order(3)
		public void testSingleMusic(){
		Music music = musicRepository.findById((long)4).get();
		assertEquals("follow me",music.getAlbum());

		}
//
//
//
//		@Test
////		@Order(4)
//		public void testUpdate(){
//
//		Music music = musicRepository.findByAlbum("follow me").get();
//		music.setName("baba");
//		musicRepository.save(music);
//		assertNotEquals("praise heavens",musicRepository.findByAlbum("follow me").get());
//
//		}
//
		@Test
        @Order(4)
	public void testDelete(){
		musicRepository.deleteById((long)4);
		assertThat(musicRepository.existsById((long)4)).isFalse();


		}



}
