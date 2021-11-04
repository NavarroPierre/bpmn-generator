package com.navarrop.bpmn.model.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.navarrop.bpmn.model.dto.BpmnDefinitions;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.xml.bind.Marshaller.JAXB_ENCODING;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;
import static org.xmlunit.assertj.XmlAssert.assertThat;

class MyAppTest {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static BpmnDefinitions definitions;
    private static StreamSource xsd;
    private static String xml;

    @BeforeAll
    public static void before() throws IOException {

        ClassLoader classLoader = MyApp.class.getClassLoader();
        xsd = new StreamSource(new File(classLoader.getResource("xsd/all.xsd").getFile()));

        File file = new File(classLoader.getResource("xml/myDef.xml").getFile());
        xml = FileUtils.readFileToString(file, "UTF-8");
        assertThat(xml).isValidAgainst(xsd);

        file = new File(classLoader.getResource("gson/myDef.json").getFile());
        String json = FileUtils.readFileToString(file, "UTF-8");

        definitions = gson.fromJson(json, BpmnDefinitions.class);
    }

    @DisplayName("Test jackson")
    @Test
    public void testJackson() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        String output = xmlMapper
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(definitions);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        sb.append(output);

        System.out.println(sb);

        assertThat(sb.toString()).isValidAgainst(xsd);
        assertThat(xml).and(sb.toString())
                .ignoreWhitespace().areIdentical();
    }

    @DisplayName("Test jaxb")
    @Test
    public void testJaxb() throws Exception {
        JAXBContext context = JAXBContext.newInstance(BpmnDefinitions.class);
        Marshaller marshaller= context.createMarshaller();
        marshaller.setProperty(JAXB_ENCODING, UTF_8.toString());
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);
        marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                new CharacterEscapeHandler() {
                    @Override
                    public void escape(char[] ac, int i, int j, boolean flag,
                                       Writer writer) throws IOException {
                        writer.write(ac, i, j);
                    }
                });

        StringWriter sw = new StringWriter();
        marshaller.marshal(definitions, sw);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        sb.append(sw);

        System.out.println(sb);
        assertThat(sb.toString()).isValidAgainst(xsd);
        assertThat(xml).and(sb.toString())
                .ignoreWhitespace().areIdentical();
    }

}