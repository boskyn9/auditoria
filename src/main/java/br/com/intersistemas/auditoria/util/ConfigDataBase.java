/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import java.util.List;

/**
 *
 * @author bosco
 */
public class ConfigDataBase {

    private List<DataBase> dataBases;
    private String host;
    private String port;
    private String user;
    private String password;

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

    @Override
    public String toString() {
        return "ConfigDataBase{" + "dataBases=" + dataBases + ", host=" + host + ", port=" + port + ", user=" + user + ", password=" + password + '}';
    }

}
