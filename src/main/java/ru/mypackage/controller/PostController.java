package ru.mypackage.controller;

import ru.mypackage.model.Post;
import ru.mypackage.model.PostStatus;
import ru.mypackage.model.Tag;
import ru.mypackage.model.Writer;
import ru.mypackage.repository.hibernate.HiberPostRepositoryImpl;
import ru.mypackage.service.PostService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class PostController {
    private PostService postService = new PostService(new HiberPostRepositoryImpl());

    private List<Tag> createListOfTags(String strTagIds) {
        List<Tag> list = new ArrayList<>();
        TagController tagController = new TagController();

        for (String str : strTagIds.split(", ")) {
            list.add(tagController.getAll().stream().filter(a->a.getId()==parseLong(str)).findFirst().orElse(null));
        }
        return list;
    }

    private Writer getWriter(String writerId){
        WriterController writerController = new WriterController();
        return writerController.getById(writerId);
    }

    public List<Post> getAll(){
        return postService.getAll();
    }

    public Post getById(String id){
        return postService.getById(parseLong(id));
    }

    public Post save(String content, String tagIds, String writerId, String status){
        Post post = new Post();
        post.setContent(content);
        post.setTags(createListOfTags(tagIds));

        if (status.equals("ACTIVE")) {
            post.setStatus(PostStatus.ACTIVE);
        } else {
            post.setStatus(PostStatus.DELETED);
        }

        post.setWriter(getWriter(writerId));

        return postService.save(post);
    }

    public Post update(String id, String content, String tagIds, String writerId, String status){
        Post post = new Post();
        post.setId(parseLong(id));
        post.setContent(content);
        post.setTags(createListOfTags(tagIds));

        if (status.equals("ACTIVE")) {
            post.setStatus(PostStatus.ACTIVE);
        } else {
            post.setStatus(PostStatus.DELETED);
        }

        post.setWriter(getWriter(writerId));

        return postService.update(post);
    }

    public void remove(String id){
        postService.remove(parseLong(id));
    }
}
