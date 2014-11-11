package br.com.fipgati.eventos.domain.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ArquivoUtil {

    public void salva(UploadedFile arq, String path, String filename) {
        File folder = new File(path);
        folder.mkdirs();
        File destino = new File(path, filename);
        try {
            IOUtils.copyLarge(arq.getFile(), new FileOutputStream(destino));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao copiar arquivo", e);
        }

    }
}
