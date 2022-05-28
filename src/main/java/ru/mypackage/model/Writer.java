package ru.mypackage.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "writers")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Post> posts;

    public Writer() {
    }

    public Writer(String name) {
        this.name = name;
    }

    public Writer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(id, writer.id) && Objects.equals(name, writer.name) && Objects.equals(posts, writer.posts);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    private String toPosts(List<Post> posts) {
        StringBuilder sb = new StringBuilder("{");
        posts.forEach(p -> sb.append("id:" + p.getId() + ", "));
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + toPosts(posts) +
                '}';
    }
}
