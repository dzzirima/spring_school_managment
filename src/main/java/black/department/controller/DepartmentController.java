package black.department.controller;

import black.department.model.Department;
import black.department.service.DepartmentServiceImpl;
import black.department.service.IDepartmentService;
import black.exception.ResourseNotFoundExecption;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/departments")
@RestController
public class DepartmentController {
    private  final DepartmentServiceImpl departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department saveDepartment(
           @RequestBody Department department
){
        LOGGER.info("Inside the save Department of DepartmentController !!!");
return  departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchAllDepartments(){
        return  departmentService.fetchAllDepartments();
    }

    @GetMapping("{departmentId}")
    public  Department fetchDepartmentById(
            @PathVariable Long departmentId
    ) throws ResourseNotFoundExecption {
        LOGGER.info("Inside the save Department of DepartmentController !!!");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("{departmentId}")
    public  String deleteDepartmentById(
            @PathVariable Long departmentId
    ){
        departmentService.deleteDepartmentById(departmentId);
        return "Department id [ %d ] deleted successfully".formatted(departmentId);
    }


    @PutMapping("{departmentId}")
    public Department upDateDepartment(
            @PathVariable Long departmentId ,
           @Valid @RequestBody Department department
    ){
        return  departmentService.updateDepartment(departmentId , department);

    }

    @GetMapping("namme/{name}")
    public  Department fetchDepartmentByName(
             @PathVariable String name
    ){
        return  departmentService.fetchDepartmentByName(name);
    }




}
