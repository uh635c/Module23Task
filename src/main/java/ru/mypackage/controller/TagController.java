package ru.mypackage.controller;

import ru.mypackage.model.Tag;
import ru.mypackage.repository.hibernate.HiberTagRepositoryImpl;
import ru.mypackage.service.TagService;

import java.util.List;

import static java.lang.Long.parseLong;

public class TagController {
    TagService tagService = new TagService(new HiberTagRepositoryImpl());

    public List<Tag> getAll(){
        return tagService.getAll();
    }

    public Tag getById(String id){
        return tagService.getById(parseLong(id));
    }

    public Tag save(String name){
        Tag tag = new Tag(name);
        return tagService.save(tag);
    }

    public Tag update(String id, String name){
        Tag tag = new Tag(name);
        tag.setId(parseLong(id));
        return tagService.update(tag);
    }

    public void remove(String id){
        tagService.remove(parseLong(id));
    }

}
