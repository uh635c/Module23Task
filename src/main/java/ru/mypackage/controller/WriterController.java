package ru.mypackage.controller;

import ru.mypackage.model.Writer;
import ru.mypackage.repository.hibernate.HiberWriterRepositoryImpl;
import ru.mypackage.service.WriterService;
import java.util.List;

import static java.lang.Long.parseLong;

public class WriterController {
    WriterService writerService=new WriterService(new HiberWriterRepositoryImpl());

    public List<Writer> getAll(){
        return writerService.getAll();
    }

    public Writer getById(String id){
        return writerService.getById(parseLong(id));
    }

    public Writer save(String name){
        Writer writer = new Writer(name);
        return writerService.save(writer);
    }

    public Writer update(String id, String name){
        Writer writer = new Writer(name);
        writer.setId(parseLong(id));
        return writerService.update(writer);
    }

    public void remove(String id){
        writerService.remove(parseLong(id));
    }

}
