package luca.springframework.brewery.web.mappers;

import luca.springframework.brewery.domain.Beer;
import luca.springframework.brewery.web.model.V2.BeerDtoV2;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDtoV2 beerToBeerDto (Beer beer);
    Beer beerDtoToBeer (BeerDtoV2 beerDto);
}
