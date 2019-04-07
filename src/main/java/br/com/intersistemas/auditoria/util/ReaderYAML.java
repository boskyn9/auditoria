/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 *
 * @author bosco
 */
public class ReaderYAML {

    public static ConfigDataBase read() throws FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(ConfigDataBase.class));
        File file = new File("database.yaml");

        if (!file.exists()) {
            throw new FileNotFoundException("O arquivo " + file.getAbsolutePath() + " não existe.");
        }
//        log.append(file.getAbsolutePath() + "\n");
        ConfigDataBase configDatabase = yaml.load(new FileReader(file));
//        log.append(configDatabase.toString() + "\n");

        if (configDatabase == null) {
            throw new FileNotFoundException("O arquivo YAML está com estrutura inválida");
        }

        return configDatabase;
    }
}
