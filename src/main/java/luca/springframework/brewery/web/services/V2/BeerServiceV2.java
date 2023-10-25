package luca.springframework.brewery.web.services.V2;

import luca.springframework.brewery.web.model.BeerDto;
import luca.springframework.brewery.web.model.V2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);

}
