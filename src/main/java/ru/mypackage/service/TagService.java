package ru.mypackage.service;

import ru.mypackage.model.Tag;
import ru.mypackage.repository.TagRepository;

import java.util.List;

public class TagService {
    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAll(){
        return tagRepository.getAll();
    }

    public Tag getById(Long id){
        return tagRepository.getById(id);
    }

    public Tag save(Tag tag){
        return tagRepository.save(tag);
    }

    public Tag update(Tag tag){
        return tagRepository.update(tag);
    }

    public void remove (Long id){
        tagRepository.remove(id);
    }

}
