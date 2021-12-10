package com.steam.library.service;

import com.steam.library.entity.Game;
import com.steam.library.entity.Library;
import com.steam.library.entity.User;
import com.steam.library.repository.LibraryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public void addGames(String ids_str) {
        String[] ids = ids_str.replaceAll("\\[", "").replaceAll("]", "").split(" ");
        List<Library> libraries = new ArrayList<>();
        for(String id : ids) {
            libraries.add(
                    Library.builder()
                        .user(User.builder().id(1).build())
                        .game(Game.builder().id(Integer.parseInt(id)).build())
                        .build()
            );
        }

        libraryRepository.saveAll(libraries);
    }
}
