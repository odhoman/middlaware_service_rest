
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
    "detectedLanguages",
    "detectedBreak"
})
public class Property____ {

    @JsonProperty("detectedLanguages")
    private List<DetectedLanguage____> detectedLanguages = null;
    @JsonProperty("detectedBreak")
    private DetectedBreak detectedBreak;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("detectedLanguages")
    public List<DetectedLanguage____> getDetectedLanguages() {
        return detectedLanguages;
    }

    @JsonProperty("detectedLanguages")
    public void setDetectedLanguages(List<DetectedLanguage____> detectedLanguages) {
        this.detectedLanguages = detectedLanguages;
    }

    @JsonProperty("detectedBreak")
    public DetectedBreak getDetectedBreak() {
        return detectedBreak;
    }

    @JsonProperty("detectedBreak")
    public void setDetectedBreak(DetectedBreak detectedBreak) {
        this.detectedBreak = detectedBreak;
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
