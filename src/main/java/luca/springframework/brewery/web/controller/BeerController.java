package luca.springframework.brewery.web.controller;

import luca.springframework.brewery.web.model.BeerDto;

import luca.springframework.brewery.web.services.BeerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    private BeerServiceImpl beerServiceImpl;

    @GetMapping("/{beerId}")
    private ResponseEntity<BeerDto> getBeer (@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerServiceImpl.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost (@RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerServiceImpl.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> handleUpdate (@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        beerServiceImpl.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // we could have used @ResponseStatus and transform the method in a void one.
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  //since we have an empty response we use this annotation to shorten the code
    public void deleteBeer(@PathVariable UUID beerId) {

        beerServiceImpl.deleteBeer(beerId);
    }
}
