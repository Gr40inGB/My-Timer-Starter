package org.gr40in.mytimerstarter.aspect;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimerProperties.class)
@ConditionalOnProperty(prefix = "app.timer", name = "enabled", havingValue = "true")
public class TimerAspectAutoConfiguration {
    @Bean
    TimerAspect runTimer() {
        return new TimerAspect();
    }

}
