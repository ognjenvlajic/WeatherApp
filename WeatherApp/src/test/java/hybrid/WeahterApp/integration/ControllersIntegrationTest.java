package hybrid.WeahterApp.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hybrid.WeatherApp.WeatherApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApp.class)
@AutoConfigureMockMvc
public class ControllersIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void integrationTest_GetAvailableCities() throws Exception {
		this.mvc.perform(get("/api/cities").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	public void integratrionTest_GetAverageTemperatures_BadRequest() throws Exception {
		this.mvc.perform(get("/api/forecast/averageTemp").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void integratrionTest_GetAverageTemperatures() throws Exception {
		this.mvc.perform(get("/api/forecast/averageTemp?fromDate=2021-10-04T00:00:00Z&toDate=2021-10-20T00:00:00Z")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

}
