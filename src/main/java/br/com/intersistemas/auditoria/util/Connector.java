/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import groovy.sql.Sql;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.JTextArea;

/**
 *
 * @author bosco
 */
public class Connector {

    private static Connector connector;
    private static Sql sql;
    private JTextArea log;

    public static Connector getInstance() {
        if (connector == null) {
            connector = new Connector();
        }

        return connector;
    }

    private Sql getSqlInstance() throws ClassNotFoundException, SQLException, FileNotFoundException {
//        log = Main.getPrincicalGui().getLogField();
//        ConfigDataBase db = ReaderYAML.read();
//        if (sql == null) {
//            sql = Sql.newInstance("jdbc:mysql://" + db.getHost() + ":" + db.getPort() + "/" + db.getDataBase(), db.getUser(), db.getPassword(), db.getDriver());
//        }
        return sql;
    }

    public void auditori1() throws ClassNotFoundException, SQLException, FileNotFoundException {
//        sql = connector.getSqlInstance();        
//        GroovyRowResult result =  sql.firstRow("select count(1) from log_auditoria_v2");
//        log.append(result.toString()+"\n");

        ProcessBuilder proc = new ProcessBuilder();

    }
}
