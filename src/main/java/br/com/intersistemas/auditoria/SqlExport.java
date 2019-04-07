/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.auditoria;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bosco
 */
public interface SqlExport {

    public List<File> export(Map params);
}
