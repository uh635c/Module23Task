package ru.mypackage.servise;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.mypackage.model.Tag;
import ru.mypackage.repository.TagRepository;
import ru.mypackage.service.TagService;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {

    @Mock
    private static TagRepository tagRepositoryMock;
    @InjectMocks
    private static TagService tagService;

    @Test
    public void shouldReturnListOfTags(){
        List<Tag> tagsActual = new ArrayList<>();
        tagsActual.add(new Tag(1L, "tag1"));
        tagsActual.add(new Tag(2L, "tag2"));
        List<Tag> tagsExpected = new ArrayList<>();
        tagsExpected.add(new Tag(1L, "tag1"));
        tagsExpected.add(new Tag(2L, "tag2"));

        Mockito.when(tagRepositoryMock.getAll()).thenReturn(tagsActual);

        Assert.assertEquals(tagsExpected, tagService.getAll());
        Mockito.verify(tagRepositoryMock).getAll();
    }

    @Test
    public void shouldReturnTagObject(){
        Tag tagActual = new Tag(1L, "tag1");
        Tag tagExpected = new Tag(1L, "tag1");

        Mockito.when(tagRepositoryMock.getById(Mockito.any())).thenReturn(tagActual);

        Assert.assertEquals(tagExpected, tagService.getById(1L));
        Mockito.verify(tagRepositoryMock).getById(Mockito.any());
    }

    @Test
    public void shouldReturnSavedTag(){
        Tag tagActual = new Tag(1L, "tag1");
        Tag tagExpected = new Tag(1L, "tag1");

        Mockito.when(tagRepositoryMock.save(tagActual)).thenReturn(tagActual);

        Assert.assertEquals(tagExpected, tagService.save(tagActual));
        Mockito.verify(tagRepositoryMock).save(tagActual);
    }

    @Test
    public void shouldReturnUpdatedTag(){
        Tag tagActual = new Tag(1L, "tag1");
        Tag tagExpected = new Tag(1L, "tag1");

        Mockito.when(tagRepositoryMock.update(tagActual)).thenReturn(tagActual);

        Assert.assertEquals(tagExpected, tagService.update(tagActual));
        Mockito.verify(tagRepositoryMock).update(tagActual);
    }

    @Test
    public void shouldCallRemoveMethod(){
        tagService.remove(1L);

        Mockito.verify(tagRepositoryMock).remove(1L);
    }

}
