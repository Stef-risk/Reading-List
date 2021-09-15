package com.stefan.readinglist.repository;

import com.stefan.readinglist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader,String> {
    Reader findByUsername(String name);
}
