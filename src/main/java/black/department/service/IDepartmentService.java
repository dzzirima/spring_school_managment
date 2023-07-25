package black.department.service;

import black.department.model.Department;
import black.exception.ResourseNotFoundExecption;

import java.util.List;

public interface IDepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchAllDepartments();

    Department fetchDepartmentById(Long departmentId) throws ResourseNotFoundExecption;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String name);
}
