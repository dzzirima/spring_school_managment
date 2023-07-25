package black.department.controller;

import black.department.model.Department;
import black.department.service.IDepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    private Department department;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDepartmentService departmentService;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentAddress("Chitungwiza")
                .departmentCode("ZA")
                .departmentName("Introduction to testing")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        // it takes a department as input and outputs department
       Department inputDepartment = Department.builder()
                .departmentAddress("Chitungwiza")
                .departmentCode("ZA")
                .departmentName("Introduction to testing")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //mocking the post to server
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IR\",\n" +
                        "    \"departmentAddress\":\"123 Kickman\",\n" +
                        "    \"departmentCode\":\"3310\"\n" +
                        "}")

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() {
    }
}