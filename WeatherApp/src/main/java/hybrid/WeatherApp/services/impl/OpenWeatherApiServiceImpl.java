package hybrid.WeatherApp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import hybrid.WeatherApp.dto.ForecastDTO;
import hybrid.WeatherApp.services.OpenWeatherApiService;
import reactor.core.publisher.Mono;

@Service
public class OpenWeatherApiServiceImpl implements OpenWeatherApiService {

	@Value("${OWMAPI.key}")
	private String apiKey;

	@Value("${OWMAPI.baseUrl}")
	private String baseUrl;

	private final WebClient webClient;

	public OpenWeatherApiServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(baseUrl).build();
	}

	public Mono<ForecastDTO> getCityForecastData(String cityInfo) {
		String uri = UriComponentsBuilder.fromHttpUrl(this.baseUrl).queryParam("q", cityInfo)
				.queryParam("appid", this.apiKey).queryParam("units", "metric").queryParam("lang", "en").toUriString();

		return this.webClient.get().uri(uri).retrieve().bodyToMono(ForecastDTO.class);
	}

}
