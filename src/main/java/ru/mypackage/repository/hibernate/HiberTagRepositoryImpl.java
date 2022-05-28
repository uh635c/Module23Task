package ru.mypackage.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mypackage.model.Tag;
import ru.mypackage.repository.TagRepository;
import ru.mypackage.util.GetSessionFactory;

import java.util.List;

public class HiberTagRepositoryImpl implements TagRepository {

    @Override
    public List<Tag> getAll() {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Tag> tags = session.createQuery("From Tag").list();
        session.close();
        return tags;
    }

    @Override
    public Tag getById(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Tag tag = session.get(Tag.class, id);
        transaction.commit();
        session.close();
        return tag;
    }

    @Override
    public Tag save(Tag tag) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tag);
        transaction.commit();
        session.close();
        return tag;
    }

    @Override
    public Tag update(Tag tag) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tag);
        transaction.commit();
        session.close();
        return tag;
    }

    @Override
    public void remove(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Tag tag = session.get(Tag.class, id);
        session.delete(tag);
        transaction.commit();
        session.close();
    }
}
