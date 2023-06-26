package com.tree.elasticsearch.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Util {
    private static final Logger LOG = LoggerFactory.getLogger(Util.class);
    public static String loadAsString(final String path) {
        try {
            //final File resource = new ClassPathResource(path).getFile();
            //return new String(Files.readAllBytes(resource.toPath()));
            Resource resource = new ClassPathResource(path);
            InputStream is = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
}
