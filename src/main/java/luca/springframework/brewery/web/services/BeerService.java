package luca.springframework.brewery.web.services;

import luca.springframework.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
     BeerDto getBeerById(UUID beerId);

     BeerDto saveNewBeer(BeerDto beerDto);

     void updateBeer(UUID beerId, BeerDto beerDto);

     void deleteBeer(UUID beerId);
}
