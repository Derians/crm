package com.petrokomplekt.core.Clients;

import com.petrokomplekt.core.Clients.model.ClientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClientRepository extends CrudRepository<ClientModel, Long> {
    /**
     * Method findByDepartmentName
     *
     * @param name the client name.
     * @return the client having the passed name or null if no client is found.
     */
    ClientModel findByClientName(String name);
}
