package com.tfl.msscbeerservice.bootstrap;

import com.tfl.msscbeerservice.domain.Beer;
import com.tfl.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(33700001L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .upc(33700002L)
                    .price(new BigDecimal("11.95"))
                    .minOnHand(12)
                    .build());
        }
        System.out.println("Loaded beers " + beerRepository.count());
    }
}
