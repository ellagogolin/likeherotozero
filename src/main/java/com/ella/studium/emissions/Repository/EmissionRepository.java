package com.ella.studium.emissions.Repository;

import com.ella.studium.emissions.Entity.Emission;
import org.springframework.data.repository.CrudRepository;

public interface EmissionRepository extends CrudRepository<Emission, Long> {
    Iterable<Emission> findByCountryNameContaining(String search);
    Iterable<Emission> findByPhoneCountryCode(Integer search);
}
