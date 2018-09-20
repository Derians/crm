package com.petrokomplekt.core.Delivery;

import com.petrokomplekt.core.Delivery.model.DeliveryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeliveryRepository extends CrudRepository<DeliveryModel, Long> {
}
