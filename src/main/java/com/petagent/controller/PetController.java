package com.petagent.controller;

import com.petagent.exception.ResourceNotFoundException;
import com.petagent.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.petagent.repository.PetRepository;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable(value = "id") Integer petId)
            throws ResourceNotFoundException {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id :: " + petId));
        return ResponseEntity.ok().body(pet);
    }

    @PostMapping("/pets")//@RequestParam(required = false) String id,
    public Pet createPet( @Valid @RequestBody Pet pet)
    {
        return petRepository.save(pet);
    }



    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> updateEmployee(@PathVariable(value = "id") Integer petId,
                                                   @Valid @RequestBody Pet petDetails) throws ResourceNotFoundException {
        Pet pet =  petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id :: " + petId));

        pet.set_id(petDetails.get_id());
        pet.set_name(petDetails.get_name());

        final Pet updatedPet = petRepository.save(pet);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/pets/{id}")
    public Map<String, Boolean> deletePet(@PathVariable(value = "id") Integer petId)
            throws ResourceNotFoundException {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id :: " + petId));

        petRepository.delete(pet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
