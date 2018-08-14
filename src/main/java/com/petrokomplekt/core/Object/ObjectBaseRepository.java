package com.petrokomplekt.core.Object;

import com.petrokomplekt.core.Object.model.ObjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ObjectBaseRepository <T extends ObjectModel> extends CrudRepository<T, Long> {

    /**
     * Method findByObjectName
     *
     * @param name the object name.
     * @return the object having the passed name or null if no object is found.
     */

    public T findByObjectName(String name);
}
