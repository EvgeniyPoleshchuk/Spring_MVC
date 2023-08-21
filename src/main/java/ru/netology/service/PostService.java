package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.model.PostDTO;
import ru.netology.repository.PostRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepositoryImpl repository;
    private final MappingUtils mappingUtils;

    public PostService(PostRepositoryImpl repository, MappingUtils mappingUtils) {
        this.repository = repository;
        this.mappingUtils = mappingUtils;
    }

    public List<PostDTO> all() {
        return repository.all().stream().map(mappingUtils::mapToPostDto).collect(Collectors.toList());
    }

    public PostDTO getById(long id) {
        return mappingUtils.mapToPostDto(repository.getById(id).orElseThrow(NotFoundException::new));
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }

}
