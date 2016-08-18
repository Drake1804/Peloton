package com.drake1804.service;

import com.drake1804.Application;
import com.drake1804.domain.News;
import com.drake1804.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by Pavel.Shkaran on 8/2/2016.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void addNews(List<News> newsList) {
        int counter = 0;
        for (News news : newsList) {
            try {
                newsRepository.save(news);
                counter++;
            } catch (Exception ignored) {
            }
        }
        Application.LOGGER.log(Level.INFO, "Added "+counter+" news;");
    }

    @Override
    public void incrementNewsViews(long newsId) {
        newsRepository.incrementNewsViews(newsId);
    }


}
