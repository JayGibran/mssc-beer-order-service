package guru.sfg.beer.order.service.services.beer;

import java.util.Optional;
import java.util.UUID;

import guru.sfg.beer.order.service.web.model.BeerDTO;

public interface BeerService {
	
	Optional<BeerDTO> getBeerById(UUID id );
	
	Optional<BeerDTO> getBeerByUpc(String upc);

}
