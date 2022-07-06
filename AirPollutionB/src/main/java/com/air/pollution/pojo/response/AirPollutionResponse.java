package com.air.pollution.pojo.response;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "list"
})
@Generated("jsonschema2pojo")
public class AirPollutionResponse {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("list")
    private java.util.List<ResponseList> list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty("list")
    public java.util.List<ResponseList> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<ResponseList> list) {
        this.list = list;
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
