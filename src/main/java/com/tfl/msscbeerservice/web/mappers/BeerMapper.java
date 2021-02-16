package com.tfl.msscbeerservice.web.mappers;

import com.tfl.msscbeerservice.domain.Beer;
import com.tfl.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
