package userapi.employer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import userapi.employer.enums.Gender;
import userapi.employer.repositories.UserRepository;
import userapi.employer.services.MusicService;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployerApplication  {


	public static void main(String[] args) {
		SpringApplication.run(EmployerApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Music music = new Music();
//		music.setId(1);
//		music.setDateReleased(LocalTime.of(1,1,1));
//
//
//		System.out.println(musicService.isOutdated(music));
//	}
}
