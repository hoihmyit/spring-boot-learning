package com.spl.hm.service;

import com.spl.hm.model.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReadXMLFileTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadXMLFileTest.class);

    @Test
    public void testReadXMLFileWithDOMParser() {
        try {
            File file = new File(getClass().getClassLoader().getResource("staff.xml").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("----------------------------");

            List<Staff> staffList = new ArrayList<>();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Staff staff = new Staff();
                    staff.setId(Integer.parseInt(eElement.getAttribute("id")));
                    staff.setFirstname(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    staff.setLastname(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    staff.setNickname(eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    staff.setSalary(Float.parseFloat(eElement.getElementsByTagName("salary").item(0).getTextContent()));

                    staffList.add(staff);
                }
            }
            System.out.println(staffList);

        } catch (Exception e) {
            LOGGER.error("Cannot read xml file: {}", e.getMessage());
        }
    }

    @Test
    public void testReadXMLFileWithJackson() throws IOException {

    }
}
