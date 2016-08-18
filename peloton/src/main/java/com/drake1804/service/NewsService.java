package com.drake1804.service;

import com.drake1804.domain.News;

import java.util.List;

/**
 * Created by Pavel.Shkaran on 8/2/2016.
 */
public interface NewsService {

    void addNews(List<News> newsList);

    void incrementNewsViews(long newsId);
}
