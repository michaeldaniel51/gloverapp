package danny.musicmanager.repositories;


import danny.musicmanager.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository <Album,Integer> {





}
