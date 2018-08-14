package com.petrokomplekt.core.Clients;

import com.petrokomplekt.core.Clients.model.ClientModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClientRepository extends ClientBaseRepository<ClientModel> {
}
