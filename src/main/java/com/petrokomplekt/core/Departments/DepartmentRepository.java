package com.petrokomplekt.core.Departments;

import com.petrokomplekt.core.Departments.model.DepartmentModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepartmentRepository extends DepartmentBaseRepository<DepartmentModel> {
}
