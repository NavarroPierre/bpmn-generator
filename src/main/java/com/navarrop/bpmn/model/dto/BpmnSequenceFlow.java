package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "sequenceFlow")
@Setter
@Getter
public class BpmnSequenceFlow extends BpmnNode{

    public BpmnSequenceFlow(String id, String name) {
        setId(id);
        setName(name);
    }

    @JacksonXmlProperty(isAttribute = true, localName = "sourceRef")
    private String sourceRef;

    @JacksonXmlProperty(isAttribute = true, localName = "targetRef")
    private String targetRef;

    public static BpmnSequenceFlow build(final String id, final String name,
                                         final String sourceRef, final String targetRef) {
        BpmnSequenceFlow flow = new BpmnSequenceFlow(id, name);
        flow.setSourceRef(sourceRef);
        flow.setTargetRef(targetRef);
        return flow;
    }
}
