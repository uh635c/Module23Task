package ru.mypackage.service;

import ru.mypackage.model.Post;
import ru.mypackage.repository.PostRepository;

import java.util.List;

public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll(){
        return postRepository.getAll();
    }

    public Post getById(Long id){
        return postRepository.getById(id);
    }

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post update(Post post){
        return postRepository.update(post);
    }

    public void remove(Long id){
        postRepository.remove(id);
    }

}
