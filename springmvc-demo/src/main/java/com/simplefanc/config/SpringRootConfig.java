package com.simplefanc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * SpringContext中相关的bean
 */
@Configuration
@ComponentScan("com.simplefanc.service")
public class SpringRootConfig {

}
