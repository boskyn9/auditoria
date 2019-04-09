/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 *
 * @author bosco
 */
public class ReaderYAML {

    public static ConfigMysqlConnection read() throws FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(ConfigMysqlConnection.class));
        File file = new File("database.yaml");

        if (!file.exists()) {
            throw new FileNotFoundException("O arquivo " + file.getAbsolutePath() + " não existe.");
        }
//        log.append(file.getAbsolutePath() + "\n");
        ConfigMysqlConnection configMysqlConnection = yaml.load(new FileReader(file));
//        log.append(configDatabase.toString() + "\n");

        if (configMysqlConnection == null) {
            throw new FileNotFoundException("O arquivo YAML está com estrutura inválida");
        }

        return configMysqlConnection;
    }
    
   /* public static void main(String[] args) {
        try {
            ConfigMysqlConnection configMysqlConnection = ReaderYAML.read();
            System.out.println(configMysqlConnection.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderYAML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
