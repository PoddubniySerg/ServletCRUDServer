package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository implements IPostRepository {

    protected static final long START_ID = 0L;

    private final ConcurrentMap<Long, Post> posts;

    private final AtomicLong counter = new AtomicLong(START_ID + 1);

    public PostRepository() {
        this.posts = new ConcurrentHashMap<>();
    }

    @Override
    public List<Post> all() {
        return List.copyOf(posts.values());
    }

    @Override
    public Optional<Post> getById(long id) {
        return posts.values().stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    @Override
    public Post save(Post post) {
        final var id = post.getId();
        if (id != START_ID && !posts.containsKey(id)) {
            throw new NotFoundException();
        }
        if (id == START_ID) {
            post.setId(counter.getAndIncrement());
        }
        posts.put(post.getId(), post);
        return posts.get(post.getId());
    }

    @Override
    public void removeById(long id) {
        posts.remove(id);
    }
}
