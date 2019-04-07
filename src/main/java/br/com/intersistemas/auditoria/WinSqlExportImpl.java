/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria;

import br.com.intersistemas.auditoria.util.ConfigDataBase;
import br.com.intersistemas.auditoria.util.ReaderYAML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bosco
 */
public class WinSqlExportImpl implements SqlExport {

    @Override
    public List<File> export(Map params) {
        List<File> files = new ArrayList<>();

        try {
            String home = System.getProperty("user.home");
            ConfigDataBase db = ReaderYAML.read();

            db.getDataBases().forEach(dataBase -> {

                try {
                    String fileName = home + "/auditoria_" + new Date().getTime() + ".html";
                    File file = new File(fileName);

                    String command = String.format("mysql -h %s -u %s -p%s -D %s -H -e \" %s \" > %s", db.getHost(), db.getUser(), db.getPassword(), dataBase.getName(), db.getSql(params), fileName);

                    System.out.println(command);

                    ProcessBuilder processBuilder = new ProcessBuilder();
                    processBuilder.command(command);
                    Process process = processBuilder.start();
                    process.waitFor();

                    if (file.length() > 0) {
                        files.add(file);
                    } else {
                        file.delete();
                    }

                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(LinuxSqlExportImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LinuxSqlExportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return files;
    }

}
