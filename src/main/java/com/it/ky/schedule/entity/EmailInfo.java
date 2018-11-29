package com.it.ky.schedule.entity;

import lombok.Data;
import lombok.Getter;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 17:22
 */
public class EmailInfo {
    private Integer id;
    private String emailTheme;
    private String emailContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
}
