package com.petrokomplekt.core.Departments;

import com.petrokomplekt.core.Departments.model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepartmentRepository extends CrudRepository<DepartmentModel, Long> {
    /**
     * Method findByDepartmentName
     *
     * @param name the department name.
     * @return the department having the passed name or null if no department is found.
     */
    DepartmentModel findByDepartmentName(String name);
}
