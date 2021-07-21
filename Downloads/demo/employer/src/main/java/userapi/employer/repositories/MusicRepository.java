package userapi.employer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userapi.employer.models.Music;
import userapi.employer.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository <Music,Long> {




    Optional<Music> findByAlbum(String album);


    List<Music> findByUser(User user);

}
