package com.navarrop.bpmn.model.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.navarrop.bpmn.model.dto.BpmnDefinitions;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

import static org.xmlunit.assertj.XmlAssert.assertThat;

class MyAppTest {

    @DisplayName("Test")
    @Test
    public void test() throws IOException {
        ClassLoader classLoader = MyApp.class.getClassLoader();
        File file = new File(classLoader.getResource("gson/myDef.json").getFile());
        String json = FileUtils.readFileToString(file, "UTF-8");
//        System.out.println(json);
//        System.out.println("");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BpmnDefinitions definitions = gson.fromJson(json, BpmnDefinitions.class);

        XmlMapper xmlMapper = new XmlMapper();
        String output = xmlMapper
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(definitions);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        sb.append(output);

        System.out.println(sb);

        file = new File(classLoader.getResource("xml/myDef.xml").getFile());
        String xml = FileUtils.readFileToString(file, "UTF-8");

        StreamSource xsd = new StreamSource(new File(classLoader.getResource("xsd/BPMN20.xsd").getFile()));

        assertThat(xml).and(sb.toString()).areIdentical();
        assertThat(xml).isValidAgainst(xsd);
    }

}