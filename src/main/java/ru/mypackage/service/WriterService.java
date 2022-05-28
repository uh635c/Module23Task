package ru.mypackage.service;



import ru.mypackage.model.Writer;
import ru.mypackage.repository.WriterRepository;

import java.util.List;

public class WriterService {
    WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public List<Writer> getAll(){
        return writerRepository.getAll();
    }

    public Writer getById(Long id){
        return writerRepository.getById(id);
    }

    public Writer save(Writer writer){
        return writerRepository.save(writer);
    }

    public Writer update(Writer writer){
        return writerRepository.update(writer);
    }

    public void remove(Long id){
        writerRepository.remove(id);
    }
}
