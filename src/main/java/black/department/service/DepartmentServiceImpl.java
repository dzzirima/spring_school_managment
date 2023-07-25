package black.department.service;


import black.department.model.Department;
import black.department.repository.IDepartmentRepository;
import black.exception.ResourseNotFoundExecption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements  IDepartmentService {

    private final IDepartmentRepository departmentRepository;

    public DepartmentServiceImpl(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws ResourseNotFoundExecption {
        return departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourseNotFoundExecption("No such element found")
        );
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();

        // lazy to do the checking

        if(department.getDepartmentAddress() != null){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }
}
