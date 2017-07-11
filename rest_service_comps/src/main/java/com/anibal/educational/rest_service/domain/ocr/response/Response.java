
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
    "textAnnotations",
    "fullTextAnnotation"
})
public class Response {

    @JsonProperty("textAnnotations")
    private List<TextAnnotation> textAnnotations = null;
    @JsonProperty("fullTextAnnotation")
    private FullTextAnnotation fullTextAnnotation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("textAnnotations")
    public List<TextAnnotation> getTextAnnotations() {
        return textAnnotations;
    }

    @JsonProperty("textAnnotations")
    public void setTextAnnotations(List<TextAnnotation> textAnnotations) {
        this.textAnnotations = textAnnotations;
    }

    @JsonProperty("fullTextAnnotation")
    public FullTextAnnotation getFullTextAnnotation() {
        return fullTextAnnotation;
    }

    @JsonProperty("fullTextAnnotation")
    public void setFullTextAnnotation(FullTextAnnotation fullTextAnnotation) {
        this.fullTextAnnotation = fullTextAnnotation;
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
