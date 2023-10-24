package luca.springframework.brewery.web.controller;

import luca.springframework.brewery.web.model.BeerDto;

import luca.springframework.brewery.web.services.BeerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
