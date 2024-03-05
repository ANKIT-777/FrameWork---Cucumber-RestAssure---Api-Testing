package utills;

import groovy.xml.XmlParser;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class configReader {
    public String getReportConfigPath() throws SAXNotSupportedException, SAXNotRecognizedException {
        XmlParser properties = null;
        String reportConfigPath = (String) properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
