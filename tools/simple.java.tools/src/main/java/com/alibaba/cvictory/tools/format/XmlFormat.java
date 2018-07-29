package com.cvictory.javatest.cvictory.tools.format;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * @author cvictory ON 2017/11/15
 */
public class XmlFormat {
    public static void main(String[] argv) throws Exception {
        InputStream io = Thread.currentThread().getContextClassLoader().getResourceAsStream("xmlFormat.xml");
        File out = new File("xmlFormatResult.xml");
        formatXMLFile(io,out);
    }

    static void formatXMLFile(InputStream inputStream, File out) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new InputStreamReader(inputStream)));

        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        xformer.setOutputProperty(OutputKeys.METHOD, "xml");
        xformer.setOutputProperty(OutputKeys.INDENT, "yes");
        xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        Source source = new DOMSource(document);
        Result result = new StreamResult(out);
        xformer.transform(source, result);
    }
}
