package com.sax;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

//парсер читает файл построчно и передаёт данные в BookXMLHandler, который обрабатывает содержимое XML-тегов
public class Main {
    public static void main(String[] args) {
        //преобразует относительный путь в абсолютный
        String path = new File("D:/Documents/LAB_WORKS_BSUIR/СТРweb-пр/lab_2_sax/src/com/books.xml").getAbsolutePath();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance(); //возвращает экземпляр фабрики для дальнейшего создания парсера
            SAXParser parser = factory.newSAXParser();
            BookXMLHandler handler = new BookXMLHandler(); //этот обработчик будет вызываться при обнаружении тегов в XML-файле
            parser.parse(new File(path), handler);
        } catch (IOException x) {
            System.err.println(x);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
