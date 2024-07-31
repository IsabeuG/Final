package org.example.demo.test;

import org.example.demo.entity.File;
import org.example.demo.repository.FileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Mock
    private FileRepository fileRepository;

    @InjectMocks
    private FileService fileService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFilesByUserId() {
        List<File> files = new ArrayList<>();
        File file = new File();
        file.setFileName("testfile.txt");
        files.add(file);

        when(fileRepository.findByUserId(1L)).thenReturn(files);

        List<File> result = fileService.getFilesByUserId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("testfile.txt", result.get(0).getFileName());
    }

    @Test
    public void testSaveFile() {
        File file = new File();
        file.setFileName("testfile.txt");

        when(fileRepository.save(file)).thenReturn(file);

        File savedFile = fileService.save(file);

        assertNotNull(savedFile);
        assertEquals("testfile.txt", savedFile.getFileName());
        verify(fileRepository, times(1)).save(file);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(fileRepository).deleteById(1L);

        fileService.deleteById(1L);

        verify(fileRepository, times(1)).deleteById(1L);
    }
}