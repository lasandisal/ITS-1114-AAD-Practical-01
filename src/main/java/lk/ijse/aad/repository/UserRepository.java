package lk.ijse.aad.repository;

import lk.ijse.aad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user WHERE (?1 IS NULL OR first_name LIKE %?1%) AND " +
            "(?2 IS NULL OR last_name LIKE %?2%)",
            nativeQuery = true)
    List<User> fiilerUsers(String firstName, String lastName);
}
