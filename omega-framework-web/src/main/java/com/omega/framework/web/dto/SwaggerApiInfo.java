package com.omega.framework.web.dto;

/**
 * @Author lviter
 * @Description
 * @Date 15:26 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class SwaggerApiInfo {


    /**
     * swagger标题
     */
    private String title;

    /**
     * 负责人
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 版本
     */
    private String version;

    public SwaggerApiInfo() {
    }

    public SwaggerApiInfo(String title, String name, String email, String version) {
        this.title = title;
        this.name = name;
        this.email = email;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
