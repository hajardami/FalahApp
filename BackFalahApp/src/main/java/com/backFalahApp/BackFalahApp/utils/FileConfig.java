package com.backFalahApp.BackFalahApp.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix ="file")
@Component
public class FileConfig {
    private String directory;
}
