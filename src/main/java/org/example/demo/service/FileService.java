package org.example.demo.service;

import org.example.demo.entity.File;
import org.example.demo.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getFilesByUserId(Long userId) {
        return fileRepository.findByUserId(userId);
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public void deleteById(Long id) {
        fileRepository.deleteById(id);
    }
}