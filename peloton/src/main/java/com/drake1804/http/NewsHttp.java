package com.drake1804.http;

import com.drake1804.Application;
import com.drake1804.domain.Page;
import com.drake1804.parser.ParsingResources;
import com.drake1804.utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Pavel.Shkaran on 7/29/2016.
 */
public class NewsHttp {

    private OkHttpClient okHttpClient;
    private Request request;


    public NewsHttp() {
        okHttpClient = new OkHttpClient();
    }


    public List<Page> updateData(ParsingResources resources) throws IOException {
        List<Page> pageList = new ArrayList<>();
        switch (resources) {
            case F1NEWS:
                pageList.add(loadPage(Constants.NEWS_F1NEWS));
                break;
            case CHAMPIONAT:
                pageList.add(loadPage(Constants.NEWS_CHAMPIONAT));
                break;
            case ALL:
                pageList.add(loadPage(Constants.NEWS_F1NEWS));
                pageList.add(loadPage(Constants.NEWS_CHAMPIONAT));
                break;
        }

        return pageList;
    }

    private Page loadPage(String pageUrl) throws IOException {
        request = new Request.Builder().url(pageUrl).build();
        Response response = okHttpClient.newCall(request).execute();
        URL url = new URL(pageUrl);
        Application.LOGGER.log(Level.INFO, "Request to: "+url.getHost());
        String tmp = response.body().string();
        byte[] byteText = tmp.getBytes(Charset.forName("UTF-8"));

        return new Page(new String(byteText, "UTF-8"), url.getHost());
    }

}
