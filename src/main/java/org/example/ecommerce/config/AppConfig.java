package org.example.ecommerce.config;

import org.example.ecommerce.model.AppRole;
import org.example.ecommerce.model.Role;
import org.example.ecommerce.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner seedRoles(RoleRepository roleRepository) {
        return args -> {
            for (AppRole appRole : AppRole.values()) {
                roleRepository.findByRoleName(appRole)
                        .orElseGet(() -> roleRepository.save(new Role(appRole)));
            }
        };
    }
}
