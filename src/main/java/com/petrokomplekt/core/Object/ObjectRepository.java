package com.petrokomplekt.core.Object;

import com.petrokomplekt.core.Object.model.ObjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ObjectRepository extends CrudRepository<ObjectModel, Long> {
    /**
     * Method findByObjectName
     *
     * @param name the object name.
     * @return the object having the passed name or null if no object is found.
     */

    ObjectModel findByObjectName(String name);
}
