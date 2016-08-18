package com.drake1804.controller;

import com.drake1804.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pavel.Shkaran on 7/28/2016.
 */
@RestController
public class NewsController {

    @Autowired
    NewsRepository newsRepository;


}
