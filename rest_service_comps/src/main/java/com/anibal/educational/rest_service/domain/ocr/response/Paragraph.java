
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
    "words"
})
public class Paragraph {

    @JsonProperty("property")
    private Property__ property;
    @JsonProperty("boundingBox")
    private BoundingBox_ boundingBox;
    @JsonProperty("words")
    private List<Word> words = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("property")
    public Property__ getProperty() {
        return property;
    }

    @JsonProperty("property")
    public void setProperty(Property__ property) {
        this.property = property;
    }

    @JsonProperty("boundingBox")
    public BoundingBox_ getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("boundingBox")
    public void setBoundingBox(BoundingBox_ boundingBox) {
        this.boundingBox = boundingBox;
    }

    @JsonProperty("words")
    public List<Word> getWords() {
        return words;
    }

    @JsonProperty("words")
    public void setWords(List<Word> words) {
        this.words = words;
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
