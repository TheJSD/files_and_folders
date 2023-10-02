package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.Person;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component //Comment this out if you do not to run the data loader.
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Person person = new Person("Maggie");
        personRepository.save(person);

        Folder folder = new Folder("Python Stuff", person);
        folderRepository.save(folder);

        File file1 = new File("conditionals", "py", 307, folder);
        fileRepository.save(file1);

        File file2 = new File("hangry", "py", 291, folder);
        fileRepository.save(file2);
    }
}
