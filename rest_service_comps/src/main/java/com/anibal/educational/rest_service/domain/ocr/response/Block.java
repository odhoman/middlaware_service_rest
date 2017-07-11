
package com.anibal.educational.rest_service.domain.ocr.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "property",
    "boundingBox",
    "paragraphs",
    "blockType"
})
public class Block {

    @JsonProperty("property")
    private Property_ property;
    @JsonProperty("boundingBox")
    private BoundingBox boundingBox;
    @JsonProperty("paragraphs")
    private List<Paragraph> paragraphs = null;
    @JsonProperty("blockType")
    private String blockType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("property")
    public Property_ getProperty() {
        return property;
    }

    @JsonProperty("property")
    public void setProperty(Property_ property) {
        this.property = property;
    }

    @JsonProperty("boundingBox")
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("boundingBox")
    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    @JsonProperty("paragraphs")
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    @JsonProperty("paragraphs")
    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @JsonProperty("blockType")
    public String getBlockType() {
        return blockType;
    }

    @JsonProperty("blockType")
    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
