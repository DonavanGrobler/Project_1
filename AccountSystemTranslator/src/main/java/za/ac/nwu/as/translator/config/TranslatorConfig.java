package za.ac.nwu.as.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.as.repo.config.RepositoryConfig;
import org.springframework.context.annotation.ComponentScan;

@Import(RepositoryConfig.class)
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.as.translator"
})
public class TranslatorConfig {
}