//package black.department.service;
//
//import black.department.model.Department;
//import black.department.repository.IDepartmentRepository;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class IDepartmentServiceTest {
//    @Autowired
//    private  IDepartmentService departmentService;
//    @MockBean
//    private IDepartmentRepository departmentRepository;
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .departmentName("CK")
//                .departmentAddress("Harare")
//                .departmentCode("CKH")
//                .departmentId(1L)
//                .build();
//        Mockito.when(departmentRepository.findByDepartmentName("CK")).thenReturn(department);
//
//    }
//    @Test
//    @DisplayName("Get Data based on valid department name")
//    public  void whenValidDepartmentName_thenDepartmentShouldFound(){
//        String departmentName = "CK";
//        // but as we can see this is still calling the real database we need to mock the repository
//        Department department = departmentService.fetchDepartmentByName(departmentName);
////        System.out.println("department = " + department);
//        assertEquals(departmentName , department.getDepartmentName());
//    }
//
//    @Test
//    public void whenValidDepartmentName_thenDepartmentShouldFoundIgnoreCase(){
//        // when testing we always mock the layer 1 bottom of it
//        // this  allows us to isolate all the errors into 1 layer and test it extensively
////        departmentService.fe
//
//    }
//
//
//}