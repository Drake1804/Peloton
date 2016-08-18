package com.drake1804.parser;

import com.drake1804.domain.News;
import com.drake1804.domain.Page;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel.Shkaran on 7/29/2016.
 */
public class NewsParser {

    public List<News> parse(List<Page> pageList) throws IOException, SAXException, ParserConfigurationException, ParseException {
        List<News> newsList = new ArrayList<>();
        for(Page page : pageList){
            Document doc = getDocumentFromString(page.getXml());
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");
            for(int i=0; i<nList.getLength(); i++){
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

                    News news = new News(element.getElementsByTagName("title").item(0).getTextContent(),
                            element.getElementsByTagName("description").item(0).getTextContent(),
                            element.getElementsByTagName("link").item(0).getTextContent(),
                            element.getElementsByTagName("enclosure").item(0).getAttributes().item(2).getTextContent(),
                            formatter.parse(element.getElementsByTagName("pubDate").item(0).getTextContent()));

                    newsList.add(news);
                }
            }
        }

        return newsList;
    }

    private Document getDocumentFromString(String xml) throws ParserConfigurationException, IOException, SAXException {
        InputSource is= new InputSource(new StringReader(xml));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        return builder.parse(is);
    }
}
