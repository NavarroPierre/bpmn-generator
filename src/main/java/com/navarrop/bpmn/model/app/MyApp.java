package com.navarrop.bpmn.model.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.navarrop.bpmn.model.dto.BpmnDefinitions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MyApp {

    public static void main (String[] args) throws IOException {

        ClassLoader classLoader = MyApp.class.getClassLoader();
        File file = new File(classLoader.getResource("gson/myDef.json").getFile());
        String json = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(json);
        System.out.println("");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BpmnDefinitions definitions = gson.fromJson(json, BpmnDefinitions.class);

        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper
                    .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(definitions);
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            System.out.println(xml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
