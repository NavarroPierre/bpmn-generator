package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.JsonAdapter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "process")
@JacksonXmlRootElement(localName = "process")
public class BpmnProcess extends BpmnNode{

    public BpmnProcess() {
        this.tasks = new ArrayList<>();
        this.sequenceFlows = new ArrayList<>();
    }

    @XmlAttribute(name = "isExecutable")
    @JacksonXmlProperty(isAttribute = true, localName = "isExecutable")
    private Boolean isExecutable = true;

    @XmlElement(name = "startEvent")
    @JacksonXmlProperty(localName = "startEvent")
    private BpmnStartEvent start;

    @XmlElement(name = "userTask")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "userTask")
    private List<BpmnUserTask> tasks;

    @XmlElement(name = "boundaryEvent")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "boundaryEvent")
    private List<BpmnBoundaryEvent> boundaryEvents;

    @XmlElement(name = "endEvent")
    @JacksonXmlProperty(localName = "endEvent")
    private BpmnEndEvent end;

    @XmlElement(name = "sequenceFlow")
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
