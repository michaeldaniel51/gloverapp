package danny.musicmanager.services;


import danny.musicmanager.entities.Album;
import danny.musicmanager.entities.Comment;
import danny.musicmanager.repositories.AlbumRepository;
import danny.musicmanager.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {


    private final AlbumRepository albumRepository;
    private final SecurityService securityService;
    private final CommentRepository commentRepository;

    public Album saveAlbum (Album album){
        album.setUser(securityService.authenticatedUser());
        return albumRepository.save(album);

    }

    public void deleteAlbum(int id){
        albumRepository.deleteById(id);

    }


    public Album CommentOnAlbum(int id, Comment comment){

        Album album = findAlbumById(id);
        comment.setAlbum(album);
        comment.setUser(securityService.authenticatedUser());
        commentRepository.save(comment);
        return albumRepository.save(album);


    }

    public List<Album> findAllAlbum(){

        return albumRepository.findAll();

    }

    public Album findAlbumById(int id){

        return albumRepository.findById(id).get();

    }



}
