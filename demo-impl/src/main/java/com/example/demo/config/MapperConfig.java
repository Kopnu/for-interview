package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

/**
 * MapperConfig
 *
 * @author Sergei_Konilov
 */
@Slf4j
@Configuration
public class MapperConfig implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory mapperFactory) {
//        mapperFactory.classMap(Person.class, Person.class)
//                .byDefault()
//                .register();
    }
}
