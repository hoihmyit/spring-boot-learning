package com.spl.hm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.spl.hm.model.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ReadAndWriteYamlFileTest {
    private ObjectMapper mapper;
    private File orderOutput;

    //    YAML: Ain't Another Markup Language
    @Before
    public void setup() {
        mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        orderOutput = new File("src/test/resources/orderOutput.yaml");
    }

    @After
    public void cleanup() {
        orderOutput.deleteOnExit();
    }

    @Test
    public void givenYamlInput_ObjectCreated() throws IOException {
        Order orderInput = mapper.readValue(new File(getClass().getClassLoader().getResource("orderInput.yml").getFile()), Order.class);
        System.out.println(orderInput);

        assertEquals("A001", orderInput.getOrderNo());
        assertEquals(LocalDate.parse("2021-01-22", DateTimeFormatter.ISO_DATE), orderInput.getDate());
        assertEquals("Customer, Joker", orderInput.getCustomerName());
        assertEquals(2, orderInput.getOrderLines().size());
    }

    @Test
    public void givenYamlObject_FileWritten() throws IOException {
        List<Order.OrderLine> lines = new ArrayList<>();
        lines.add(new Order.OrderLine("Copper Wire (200ft)", 1, new BigDecimal(50).setScale(2, RoundingMode.HALF_UP)));
        lines.add(new Order.OrderLine("Washers (1/4\")", 2, new BigDecimal(1.15).setScale(2, RoundingMode.HALF_UP)));
        Order orderInput = new Order(
                "B002",
                LocalDate.parse("2021-01-22", DateTimeFormatter.ISO_DATE),
                "Customer, Alan",
                lines);
        mapper.writeValue(orderOutput, orderInput);

        File outputYaml = new File(orderOutput.getAbsolutePath());
        assertTrue(outputYaml.exists());
    }
}
