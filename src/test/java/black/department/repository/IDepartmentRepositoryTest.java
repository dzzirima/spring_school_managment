package black.department.repository;

import black.department.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class IDepartmentRepositoryTest {
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        // this is the object we want to persist
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentCode("ME-01")
                        .departmentAddress("Harare HQ")
                        .departmentId(1L)
                        .build();
        // persisting the object before calling the test case
        entityManager.persist(department);
    }
    @Test
    @DisplayName("Find department when an iD is passed ")
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName() ,"Mechanical Engineering" );

    }
}