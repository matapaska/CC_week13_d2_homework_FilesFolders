package com.codeclan.example.FilesFolders.components;

import com.codeclan.example.FilesFolders.models.File;
import com.codeclan.example.FilesFolders.models.Folder;
import com.codeclan.example.FilesFolders.models.User;
import com.codeclan.example.FilesFolders.repositories.FileRepository;
import com.codeclan.example.FilesFolders.repositories.FolderRepository;
import com.codeclan.example.FilesFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User Mata = new User("Mata");
        userRepository.save(Mata);

        Folder music = new Folder("music", Mata);
        folderRepository.save(music);

        File song1 = new File("Lalala", "mp3", 30, music);
        fileRepository.save(song1);
        File song2 = new File("Nanana", "mp3", 50, music);
        fileRepository.save(song2);

        music.addFiles(song1);
        music.addFiles(song2);
        folderRepository.save(music);

        Mata.addFolder(music);
        userRepository.save(Mata);
    }


}
