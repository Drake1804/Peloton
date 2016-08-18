package com.drake1804.domain;

/**
 * Created by Pavel.Shkaran on 8/3/2016.
 */
public class Page {

    private String xml;

    private String resource;

    public Page(String xml, String resource) {
        this.xml = xml;
        this.resource = resource;
    }

    public String getXml() {
        return xml;
    }

    public String getResource() {
        return resource;
    }
}
