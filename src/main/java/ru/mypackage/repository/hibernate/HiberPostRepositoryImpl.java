package ru.mypackage.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.mypackage.model.Post;
import ru.mypackage.model.Writer;
import ru.mypackage.repository.PostRepository;
import ru.mypackage.util.GetSessionFactory;

import java.util.List;

public class HiberPostRepositoryImpl implements PostRepository {
    @Override
    public List<Post> getAll() {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Post> posts = session.createQuery("From Post").list();
        session.close();
        return posts;
    }

    @Override
    public Post getById(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = (Post) session
                .createQuery("select p from Post p left join fetch p.tags join fetch p.writer where p.id=:id")
                .setParameter("id", id)
                .uniqueResult();
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public Post save(Post post) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public void remove(Long id) {
        Session session = GetSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, id);
        session.delete(post);
        transaction.commit();
        session.close();
    }
}
