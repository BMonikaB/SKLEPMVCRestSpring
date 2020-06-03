package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.equipy.domain.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    List<User> findAllByLastNameContainingIgnoreCase(String lastName);


    User findByPesel(String pesel);

}
