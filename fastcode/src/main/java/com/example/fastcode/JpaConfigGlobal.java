package com.example.fastcode;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration 
@EnableJpaRepositories({"com.example.fastcode.repository"})
public class JpaConfigGlobal {

}
