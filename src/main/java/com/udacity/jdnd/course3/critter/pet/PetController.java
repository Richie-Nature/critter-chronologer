package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.customer.Customer;
import com.udacity.jdnd.course3.critter.user.customer.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.customer.CustomerService;
import com.udacity.jdnd.course3.critter.util.ConvertEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = convertDtoToEntity(petDTO);
        try {
            Customer owner = customerService.find(petDTO.getOwnerId());
            if(owner != null) {
                pet.setCustomer(owner);
            }
        }catch (UnsupportedOperationException e) {
            return null;
        }
        return convertEntityToDto(petService.create(pet));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.find(petId);
        PetDTO petDTO = convertEntityToDto(pet);
        petDTO.setOwnerId(pet.getCustomer().getId());
        return petDTO;
    }

    @GetMapping
    public List<PetDTO> getPets(){
       return petService.findAll().stream()
                .map(pet -> getPetDto(pet))
                .collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petService.findByOwner(ownerId).stream()
                .map(pet -> getPetDto(pet))
                .collect(Collectors.toList());
    }

    private PetDTO getPetDto(Pet pet) {
         PetDTO pd = convertEntityToDto(pet);
        pd.setOwnerId(pet.getCustomer().getId());
        return pd;
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
