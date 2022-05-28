package ru.mypackage.servise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.mypackage.model.Post;
import ru.mypackage.model.PostStatus;
import ru.mypackage.model.Tag;
import ru.mypackage.model.Writer;
import ru.mypackage.repository.PostRepository;
import ru.mypackage.service.PostService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {
    @Mock
    PostRepository postRepositoryMock;
    @InjectMocks
    PostService postService;

    @Test
    public void shouldReturnListOfPosts(){
        List<Post> postsActual = new ArrayList<>();
        postsActual.add(new Post(1L, "content1", Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null)));
        postsActual.add(new Post(2L, "content2",Arrays.asList(new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(2L, null)));

        List<Post> postsExpected = new ArrayList<>();
        postsExpected.add(new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null)));
        postsExpected.add(new Post(2L, "content2",Arrays.asList(new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(2L, null)));

        Mockito.when(postRepositoryMock.getAll()).thenReturn(postsActual);

        Assert.assertEquals(postsExpected, postService.getAll());
        Mockito.verify(postRepositoryMock).getAll();
    }

    @Test
    public void shouldReturnPostById(){
        Post postActual = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Post postExpected = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Mockito.when(postRepositoryMock.getById(Mockito.any())).thenReturn(postActual);

        Assert.assertEquals(postExpected, postService.getById(1L));
        Mockito.verify(postRepositoryMock).getById(Mockito.any());
    }

    @Test
    public void shouldReturnSavedPost(){
        Post postActual = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Post postExpected = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Mockito.when(postRepositoryMock.save(postActual)).thenReturn(postActual);

        Assert.assertEquals(postExpected, postService.save(postActual));
        Mockito.verify(postRepositoryMock).save(postActual);
    }

    @Test
    public void shouldReturnUpdatedPost(){
        Post postActual = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Post postExpected = new Post(1L, "content1",Arrays.asList(new Tag(1L, "tag1"), new Tag(2L, "tag2")),
                PostStatus.ACTIVE, new Writer(1L, null));

        Mockito.when(postRepositoryMock.update(postActual)).thenReturn(postActual);

        Assert.assertEquals(postExpected, postService.update(postActual));
        Mockito.verify(postRepositoryMock).update(postActual);

    }

    @Test
    public void shouldCallPostRepositoryRemoveMethod(){
        postService.remove(1L);

        Mockito.verify(postRepositoryMock).remove(1L);
    }
}
