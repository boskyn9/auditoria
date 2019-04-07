/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bosco
 */
public class ConfigDataBase {

    private String driver;
    private List<DataBase> dataBases;
    private String host;
    private String port;
    private String user;
    private String password;
    private String sql;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public List<DataBase> getDataBases() {
        return dataBases;
    }

    public void setDataBases(List<DataBase> dataBases) {
        this.dataBases = dataBases;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSql(Map<String, String> params) {
        if(params == null)
            return sql;
        
        params.forEach((key, value) -> {
            sql = sql.replace(key, value);
        });
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

}
