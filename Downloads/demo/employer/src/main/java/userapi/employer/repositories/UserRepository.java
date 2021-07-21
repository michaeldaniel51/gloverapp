package userapi.employer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import userapi.employer.enums.Gender;
import userapi.employer.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername (String username);

    List<User> findByOccupation (String occupation);

    List<User> findByMusicId (long id);

    List<User> findByGender(Gender gender);
}
