
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
    "symbols"
})
public class Word {

    @JsonProperty("property")
    private Property___ property;
    @JsonProperty("boundingBox")
    private BoundingBox__ boundingBox;
    @JsonProperty("symbols")
    private List<Symbol> symbols = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("property")
    public Property___ getProperty() {
        return property;
    }

    @JsonProperty("property")
    public void setProperty(Property___ property) {
        this.property = property;
    }

    @JsonProperty("boundingBox")
    public BoundingBox__ getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("boundingBox")
    public void setBoundingBox(BoundingBox__ boundingBox) {
        this.boundingBox = boundingBox;
    }

    @JsonProperty("symbols")
    public List<Symbol> getSymbols() {
        return symbols;
    }

    @JsonProperty("symbols")
    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
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
