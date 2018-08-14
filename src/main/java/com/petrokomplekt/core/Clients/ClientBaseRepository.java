package com.petrokomplekt.core.Clients;

import com.petrokomplekt.core.Clients.model.ClientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ClientBaseRepository <T extends ClientModel> extends CrudRepository<T, Long> {

    /**
     * Method findByDepartmentName
     *
     * @param name the client name.
     * @return the client having the passed name or null if no client is found.
     */
    public T findByClientName(String name);
}
