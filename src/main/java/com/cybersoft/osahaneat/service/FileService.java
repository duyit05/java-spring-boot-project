package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;
    private Path root;

    @Override
    public void init() {
        try {
            root = Paths.get(rootPath);
            if (Files.notExists(root)) {
                Files.createDirectories(root);
            }
        } catch (Exception e) {
            System.out.println("Can not init folder !!");
        }

    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            init();
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Can not save file !!!");
        }
        return false;
    }

    @Override
    public Resource loadFile(String fileName) {
       try {
           init();
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }
       }catch (Exception e){
           System.out.println("Can not load file !!");
       }
       return  null;
    }

    @Override
    public boolean deleteFile(String filename) {
        try {
            init();
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @Override
    public boolean deleteAllFile (){
        Path root = Paths.get(rootPath);
        if (Files.exists(root)) {
            try {
                FileSystemUtils.deleteRecursively(root.toFile());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
