package luca.springframework.brewery.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luca.springframework.brewery.web.model.V2.BeerStyleEnum;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
