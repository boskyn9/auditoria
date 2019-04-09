/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Suporte
 */
public class ConfigMysqlConnection {

    private String driver;
    private String sql;
    List<ConfigDataBase> hosts;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSql(Map<String, String> params) {
        if (params == null) {
            return sql;
        }

        params.forEach((key, value) -> {
            sql = sql.replace(key, value);
        });
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<ConfigDataBase> getHosts() {
        return hosts;
    }

    public void setHosts(List<ConfigDataBase> hosts) {
        this.hosts = hosts;
    }

    @Override
    public String toString() {
        return new Yaml().dump(this);
    }
    

}
