package guru.sfg.beer.order.service.services.beer;

import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import guru.sfg.beer.order.service.web.model.BeerDTO;

@ConfigurationProperties(prefix="sfg.brewery", ignoreUnknownFields = false)	
@Service
public class BeerServiceImpl implements BeerService {
	
	public final String BEER_PATH_V1 = "/api/v1/beer/";
	
	public final String BEER_UPC_PATH_V1 = "/api/v1/beerUpc/";
	
	private final RestTemplate restTemplate;
	
	private String beerServiceHost;
	
	public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public Optional<BeerDTO> getBeerById(UUID id) {
		return Optional.of(this.restTemplate.getForObject(beerServiceHost + BEER_PATH_V1 + id.toString(), BeerDTO.class));
	}

	@Override
	public Optional<BeerDTO> getBeerByUpc(String upc) {
		return Optional.of(this.restTemplate.getForObject(beerServiceHost + BEER_UPC_PATH_V1 + upc, BeerDTO.class));
	}

	public void setBeerServiceHost(String beerServiceHost) {
		this.beerServiceHost = beerServiceHost;
	}

}
