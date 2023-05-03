package com.file.controller;

import com.file.entity.Image;
import com.file.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/ImageOrFile")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public String saveImage(@RequestParam("file") MultipartFile  file,
                            @RequestParam("name") String name,
                            @RequestParam("type") String type) throws IOException {

        return imageService.saveImage(file,name,type);
    }
    @GetMapping("/download/{id}")
    public Optional<Image> downloadImage(@PathVariable("id") int id){
Optional<Image> images =imageService.downloadImageBYId(id);
        return images;
    }
    @DeleteMapping("/{id}")
    public void DeleteImage(@PathVariable("id") int id){
        imageService.deleteImage(id);

    }
}
