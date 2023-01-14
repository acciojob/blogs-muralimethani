package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image = new Image(description,dimensions);
        image.setBlog(blog);

        // this will handle the base condition;
        //if your imagelist is null

        List<Image>  listofimages= blog.getImageList();
        if (Objects.isNull(listofimages)) {
            listofimages = new ArrayList<>();
        }
        listofimages.add(image);
        blog.setImageList(listofimages);
        imageRepository2.save(image);
        blogRepository.save(blog);
        return image;
    }

    public void deleteImage(Image image){

        Blog blog = image.getBlog();

        List<Image> list = blog.getImageList();

        list.remove(image);

        blog.setImageList(list);

        imageRepository2.delete(image);

    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        return 0;
    }

    public void deleteImage(int id) {
//        Image image = imageRepository2.getOne(id);
        deleteImage(id);
    }
}