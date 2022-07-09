package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.controller.IPostController;
import ru.netology.controller.PostController;
import ru.netology.repository.IPostRepository;
import ru.netology.repository.PostRepository;
import ru.netology.service.IPostService;
import ru.netology.service.PostService;

@Configuration
public class AppConfig {

    @Bean
    public IPostController postController (IPostService service) {
        return PostController.getInstance(service);
    }

    @Bean
    public IPostService postService (IPostRepository repository) {
        return PostService.getInstance(repository);
    }

    @Bean
    public IPostRepository postRepository () {
        return PostRepository.getInstance();
    }
}
