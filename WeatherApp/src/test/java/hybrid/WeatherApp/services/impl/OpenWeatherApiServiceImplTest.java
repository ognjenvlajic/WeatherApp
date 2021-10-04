package hybrid.WeatherApp.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriComponentsBuilder;

import hybrid.WeatherApp.dto.ForecastDTO;
import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
public class OpenWeatherApiServiceImplTest {

	public final String TEST_CITY_INFO = "Amsterdam,NL";
	public final ForecastDTO FORECAST_DTO = new ForecastDTO();
	public final Mono<ForecastDTO> TEST_MONO = Mono.just(FORECAST_DTO);

	@Mock
	private WebClient webClient;
	
	@Mock
	private WebClient.Builder builder;
	
	@Mock
	private UriComponentsBuilder uriBuilder;
	
	@Mock
	OpenWeatherApiServiceImpl openWeatherApiServiceImpl;
	
	@Test
	public void emptyTest() {
		
	}
	
	// Below method cannot be tested because UriComponentsBuilder call static method what is 
	// not supported in Mockito. It can be solved with PowerMockito, but it use deprecated annotations
	
	@SuppressWarnings("unchecked")
	//@Test
	public void getCityForecastData_Should_ReturnMono() {
		@SuppressWarnings("rawtypes")
		RequestHeadersUriSpec uriSpecMock = Mockito.mock(RequestHeadersUriSpec.class);
		@SuppressWarnings("rawtypes")
		RequestHeadersSpec headersSpecMock = Mockito.mock(RequestHeadersSpec.class);
		ResponseSpec responseSpecMock = Mockito.mock(ResponseSpec.class);

		when(webClient.get()).thenReturn(uriSpecMock);
		when(uriSpecMock.uri(ArgumentMatchers.<String>notNull())).thenReturn(headersSpecMock);
		when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
		when(responseSpecMock.bodyToMono(ArgumentMatchers.<Class<ForecastDTO>>notNull())).thenReturn(Mono.just(FORECAST_DTO));

		Mono<ForecastDTO> mono = openWeatherApiServiceImpl.getCityForecastData(TEST_CITY_INFO);
		verify(webClient, Mockito.times(1)).get();
		assertNotNull(mono);
	}

}
