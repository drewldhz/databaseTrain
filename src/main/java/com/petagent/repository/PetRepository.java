package com.petagent.repository;

import com.petagent.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer> {
}
