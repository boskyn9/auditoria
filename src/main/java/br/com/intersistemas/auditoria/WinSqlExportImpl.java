/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria;

import br.com.intersistemas.auditoria.util.ConfigDataBase;
import br.com.intersistemas.auditoria.util.ConfigMysqlConnection;
import br.com.intersistemas.auditoria.util.DataBase;
import br.com.intersistemas.auditoria.util.ReaderYAML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    public List<File> export(Map params) throws FileNotFoundException {
        List<File> files = new ArrayList<>();

        String home = System.getProperty("user.home");
        // ANTES: ConfigDataBase db = ReaderYAML.read();
        ConfigMysqlConnection dbReader = ReaderYAML.read();
        List<ConfigDataBase> hosts = dbReader.getHosts();
        //db.getDataBases().forEach(dataBase -> {
//            for (int i = 0; i <; i++) { //**@brief 3 = Numero de banco de dados
        hosts.forEach(hostConfig -> {

            List<DataBase> dataBases = hostConfig.getDataBases();

            dataBases.forEach(db -> {
                try {
                       // String nameFile = dbReader.getSql(params);
                    // System.out.println("Name File: "+nameFile);
                    String fileName = home + "\\auditoria_" + +new Date().getTime() + ".html";
                    File file = new File(fileName);

                    String command = String.format("mysql -h %s -u %s -p%s -D %s -H -e \" %s \" > %s", hostConfig.getHost(), hostConfig.getUser(), hostConfig.getPassword(), db.getName(), dbReader.getSql(params), fileName);

                    System.out.println(command);

                    ProcessBuilder processBuilder = new ProcessBuilder();
                    processBuilder.command("cmd.exe", "/C", command);
                    //processBuilder.command(command);
                    Process process = processBuilder.start();
                    process.waitFor();
                    System.out.println("Ponto após executar o mysql");
                    System.out.println("Tamanho do arquivo:" + file.length());
                    if (file.length() > 0) {
                        System.out.println("Adiciona na Lista de arquivos");
                        files.add(file);
                    } else {
                        file.delete();
                        System.out.println("Deleta o arquivo");
                    }

                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(LinuxSqlExportImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        });

        return files;
    }

}
