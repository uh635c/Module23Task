package ru.mypackage.servise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.mypackage.model.Writer;
import ru.mypackage.repository.WriterRepository;
import ru.mypackage.service.WriterService;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class WriterServiceTest {
    @Mock
    WriterRepository writerRepositoryMock;
    @InjectMocks
    WriterService writerService;

    @Test
    public void shouldReturnListOfWriters(){
        List<Writer> writersActual = new ArrayList<>();
        writersActual.add(new Writer(1L, "writer1"));
        writersActual.add(new Writer(2L, "writer2"));

        List<Writer> writersExpected = new ArrayList<>();
        writersExpected.add(new Writer(1L, "writer1"));
        writersExpected.add(new Writer(2L, "writer2"));

        Mockito.when(writerRepositoryMock.getAll()).thenReturn(writersActual);

        Assert.assertEquals(writersExpected, writerService.getAll());
        Mockito.verify(writerRepositoryMock).getAll();
    }

    @Test
    public void shouldReturnWriterById(){
        Writer writerActual = new Writer(1L, "writer1");
        Writer writerExpected = new Writer(1L, "writer1");

        Mockito.when(writerRepositoryMock.getById(Mockito.any())).thenReturn(writerActual);

        Assert.assertEquals(writerExpected, writerService.getById(1L));
        Mockito.verify(writerRepositoryMock).getById(Mockito.any());
    }

    @Test
    public void shouldReturnSavedWriter(){
        Writer writerActual = new Writer(1L, "writer1");
        Writer writerExpected = new Writer(1L, "writer1");

        Mockito.when(writerRepositoryMock.save(writerActual)).thenReturn(writerActual);

        Assert.assertEquals(writerExpected, writerService.save(writerActual));
        Mockito.verify(writerRepositoryMock).save(writerActual);
    }

    @Test
    public void shouldReturnUpdatedWriter(){
        Writer writerActual = new Writer(1L, "writer1");
        Writer writerExpected = new Writer(1L, "writer1");

        Mockito.when(writerService.update(writerActual)).thenReturn(writerActual);

        Assert.assertEquals(writerExpected, writerService.update(writerActual));
        Mockito.verify(writerRepositoryMock).update(writerActual);
    }

    @Test
    public void shouldCallWriterRepositoryRemoveMethod(){
        writerService.remove(1L);

        Mockito.verify(writerRepositoryMock).remove(1L);
    }

}
