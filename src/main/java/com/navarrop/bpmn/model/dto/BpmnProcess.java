package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.JsonAdapter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "process")
public class BpmnProcess extends BpmnNode{

    public BpmnProcess() {
        this.tasks = new ArrayList<>();
        this.sequenceFlows = new ArrayList<>();
    }

    @JacksonXmlProperty(isAttribute = true, localName = "isExecutable")
    private Boolean isExecutable = true;

    @JacksonXmlProperty(localName = "startEvent")
    private BpmnStartEvent start;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "userTask")
    private List<BpmnUserTask> tasks;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "boundaryEvent")
    private List<BpmnBoundaryEvent> boundaryEvents;

    @JacksonXmlProperty(localName = "endEvent")
    private BpmnEndEvent end;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "sequenceFlow ")
    private List<BpmnSequenceFlow> sequenceFlows;

    public static BpmnProcess build(final String id, final String name) {
        BpmnProcess process = new BpmnProcess();
        process.setId(id);
        process.setName(name);
        return process;
    }

    public void addUserTask(BpmnUserTask task) {
        this.tasks.add(task);
    }

    public void addSequenceFlow(BpmnSequenceFlow flow) {
        this.sequenceFlows.add(flow);
    }
}
