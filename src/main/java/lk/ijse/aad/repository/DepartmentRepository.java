package lk.ijse.aad.repository;

import lk.ijse.aad.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "SELECT * FROM department WHERE (?1 IS NULL OR department_location LIKE %?1%) AND " +
            "(?2 IS NULL OR department_name LIKE %?2%)",
            nativeQuery = true)
    List<Department> filterDepartment(String location, String name);
}
