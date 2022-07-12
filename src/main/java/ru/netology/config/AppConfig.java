package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.controller.PostController;
import ru.netology.repository.IPostRepository;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;

@Configuration
public class AppConfig {

    @Bean
    public PostController postController(PostService service) {
        return PostController.getInstance(service);
    }

    @Bean
    public PostService postService(IPostRepository repository) {
        return PostService.getInstance(repository);
    }

    @Bean
    public IPostRepository postRepository() {
        return PostRepository.getInstance();
    }
}
