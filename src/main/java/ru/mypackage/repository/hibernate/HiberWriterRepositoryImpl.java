package ru.mypackage.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mypackage.model.Tag;
import ru.mypackage.model.Writer;
import ru.mypackage.repository.WriterRepository;
import ru.mypackage.util.GetSessionFactory;

import java.util.List;

public class HiberWriterRepositoryImpl implements WriterRepository {
    @Override
    public List<Writer> getAll() {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Writer> writers = session.createQuery("From Writer").list();
        session.close();
        return writers;
    }

    @Override
    public Writer getById(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = (Writer) session.createQuery("select w from Writer w left join fetch w.posts where w.id=:id")
                .setParameter("id", id).uniqueResult();
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public void remove(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        session.delete(writer);
        transaction.commit();
        session.close();
    }
}
