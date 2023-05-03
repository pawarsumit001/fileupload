package com.file.service;

import com.file.entity.Image;
import com.file.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;


    public String saveImage(MultipartFile file, String name, String type) throws IOException {
        Image image = new Image();
        image.setName(name);
        image.setType(type);
        image.setImage(file.getBytes());
        imageRepository.save(image);
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.isEmpty());
        return "Image saved in db";
    }

    public Optional<Image> downloadImageBYId(int id) {


        Optional<Image> optionalImage = imageRepository.findById(id);
        return optionalImage;
    }
}
