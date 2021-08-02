package danny.musicmanager.repositories;


import danny.musicmanager.entities.Album;
import danny.musicmanager.entities.Comment;
import danny.musicmanager.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Integer> {


    List<Comment> findBySong(Song song);

    List<Comment> findByAlbum(Album album);

}
