package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.util.ConvertEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = petService.create(convertDtoToEntity(petDTO));
        return convertEntityToDto(pet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        throw new UnsupportedOperationException();
    }

    private static PetDTO convertEntityToDto(Pet pet) {
        return new ConvertEntity<Pet, PetDTO>()
                .toDto(pet, new PetDTO());
    }

    private static Pet convertDtoToEntity(PetDTO petDTO) {
        return new ConvertEntity<Pet, PetDTO>()
                .toEntity(new Pet(), petDTO);
    }

}
