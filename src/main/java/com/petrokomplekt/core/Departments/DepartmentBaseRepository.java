package com.petrokomplekt.core.Departments;


import com.petrokomplekt.core.Departments.model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface DepartmentBaseRepository <T extends DepartmentModel> extends CrudRepository<T, Long> {

    /**
     * Method findByDepartmentName
     *
     * @param name the department name.
     * @return the department having the passed name or null if no department is found.
     */
    public T findByDepartmentName(String name);

}
