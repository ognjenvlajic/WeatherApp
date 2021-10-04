package hybrid.WeatherApp;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerSecondOption {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Spring Context Initialized");
    }
	
}
