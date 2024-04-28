package org.gr40in.mytimerstarter.aspect;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@Slf4j
@ConfigurationProperties(prefix = "app.timer")
public class TimerProperties {

    private boolean enabled;
    @PostConstruct
    void init() {
        log.error("am i work? ConfigurationProperties");
    }
}
