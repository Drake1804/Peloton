package com.drake1804.scheduler;

import com.drake1804.Application;
import com.drake1804.Tweakables;
import com.drake1804.http.NewsHttp;
import com.drake1804.parser.NewsParser;
import com.drake1804.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;

/**
 * Created by Pavel.Shkaran on 7/29/2016.
 */
@Component
public class NewsScheduler {

    @Autowired
    NewsService newsService;

    private NewsHttp newsHttp;
    private NewsParser newsParser;


    @Scheduled(fixedRate = Tweakables.NEWS_UPDATE_DELTA)
    public void loadNews() throws IOException, ParserConfigurationException, SAXException, ParseException {
        if(newsParser == null && newsHttp == null){
            newsHttp = new NewsHttp();
            newsParser = new NewsParser();
        }
        Application.LOGGER.log(Level.INFO, "Loading initiate");

//        newsService.incrementNewsViews(1);

        newsService.addNews(newsParser.parse(newsHttp.updateData(Tweakables.CURRENT_RESOURCES)));
    }
}
