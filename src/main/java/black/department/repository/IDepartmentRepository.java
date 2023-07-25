package black.department.repository;


import black.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department , Long> {
    public  Department  findByDepartmentName(String departmentName);
    public  Department  findByDepartmentNameIgnoreCase(String departmentName);
}
