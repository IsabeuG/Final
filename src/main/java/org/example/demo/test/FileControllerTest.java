package org.example.demo.test;

import org.example.demo.entity.File;
import org.example.demo.entity.User;
import org.example.demo.service.FileService;
import org.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FileControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FileService fileService;

    @Mock
    private UserService userService;

    @InjectMocks
    private FileController fileController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
    }

    @Test
    public void testListFiles() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        List<File> files = new ArrayList<>();
        File file = new File();
        file.setFileName("testfile.txt");
        files.add(file);

        when(userService.findByUsername("testuser")).thenReturn(user);
        when(fileService.getFilesByUserId(1L)).thenReturn(files);

        mockMvc.perform(get("/api/files")
                        .principal(() -> "testuser"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fileName").value("testfile.txt"));
    }

    @Test
    public void testUploadFile() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        MockMultipartFile multipartFile = new MockMultipartFile("file", "testfile.txt", MediaType.TEXT_PLAIN_VALUE, "Test content".getBytes());

        when(userService.findByUsername("testuser")).thenReturn(user);

        mockMvc.perform(multipart("/api/files")
                        .file(multipartFile)
                        .principal(() -> "testuser"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteFile() throws Exception {
        doNothing().when(fileService).deleteById(1L);

        mockMvc.perform(delete("/api/files/1"))
                .andExpect(status().isOk());

        verify(fileService, times(1)).deleteById(1L);
    }
}
