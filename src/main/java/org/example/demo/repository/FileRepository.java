package org.example.demo.repository;

import org.example.demo.entity.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<UserFile, Long> {
    List<UserFile> findByUserId(Long userId);
}