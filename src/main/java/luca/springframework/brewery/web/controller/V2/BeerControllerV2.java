package luca.springframework.brewery.web.controller.V2;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import luca.springframework.brewery.web.model.V2.BeerDtoV2;

import luca.springframework.brewery.web.services.V2.BeerServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    @Autowired
    private BeerServiceImplV2 beerServiceImplV2;

    @GetMapping("/{beerId}")
    private ResponseEntity<BeerDtoV2> getBeer ( @PathVariable UUID beerId) {
        return new ResponseEntity<>(beerServiceImplV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> handlePost (@Valid @RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = beerServiceImplV2.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beer" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> handleUpdate (@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceImplV2.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // we could have used @ResponseStatus and transform the method in a void one.
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  //since we have an empty response we use this annotation to shorten the code
    public void deleteBeer(@PathVariable UUID beerId) {

        beerServiceImplV2.deleteBeer(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
