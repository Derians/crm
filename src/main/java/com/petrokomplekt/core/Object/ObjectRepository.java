package com.petrokomplekt.core.Object;

import com.petrokomplekt.core.Object.model.ObjectModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ObjectRepository extends ObjectBaseRepository<ObjectModel> {
}
