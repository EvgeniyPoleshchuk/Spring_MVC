package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.model.Post;
import ru.netology.model.PostDTO;


@Service
public class MappingUtils {

    public PostDTO mapToPostDto(Post post) {
        PostDTO postDTO = new PostDTO();
        if (!post.isDeleted()) {
            postDTO.setId(post.getId());
            postDTO.setContent(post.getContent());
        } else {
            postDTO = null;
        }
        return postDTO;
    }


}
