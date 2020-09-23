package br.com.fabricio.consumirgit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Programadores {

    private List<Programador> items;
    private String total_count;
    private String incomplete_results;

    public List<Programador> getItems() {
        return items;
    }

    public void setItems(List<Programador> items) {
        this.items = items;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }
}

