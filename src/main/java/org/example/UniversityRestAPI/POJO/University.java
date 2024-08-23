package org.example.UniversityRestAPI.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class University {

    private List<String> web_pages = Collections.singletonList("Default Page");
    private List<String> domains = Collections.singletonList("Default Domain");
    @JsonProperty("state-province")
    private String state_province = "Default State";
    private String country = "Default Country";
    private String alpha_two_code = "Default Code";
    private String name = "Default University";

    public University() {
    }

    public University(List<String> web_pages, List<String> domains, String state_province, String country, String alpha_two_code, String name) {
        this.web_pages = web_pages;
        this.domains = domains;
        this.state_province = state_province;
        this.country = country;
        this.alpha_two_code = alpha_two_code;
        this.name = name;
    }

    public List<String> getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(List<String> web_pages) {
        this.web_pages = web_pages;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
