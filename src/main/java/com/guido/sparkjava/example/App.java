package com.guido.sparkjava.example;

import freemarker.template.Configuration;
import freemarker.template.Version;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static spark.Spark.get;

/**
 * @see <a href="https://github.com/perwendel/spark-template-engines/tree/master/spark-template-freemarker">spark-template-freemarker</a>
 * @see /home/guido/.m2/repository/com/sparkjava/spark-template-freemarker/2.7.1/spark-template-freemarker-2.7.1-sources.jar!/spark/template/freemarker/FreeMarkerEngine.java:32
 */
public class App {

    private static final Logger LOG = LogManager.getLogger(App.class);

    private static final String GREETING_STRING = "greetingString";

    private static final String NOW_TIME_STRING = "nowTimeString";

//    private static final String BASE_PACKAGE_PATH = "com/guido/sparkjavaexample";

    private static ModelAndView handleGet(Request req, Response res) {

        LOG.info("Received: {} {}", req.requestMethod(), req.url());
        res.header("Content-Type", "application/json");
        Map<String, Object> placeholders = new HashMap<>();
        placeholders.put(GREETING_STRING, "Ciao " + req.params(":name") + "!");
        placeholders.put(NOW_TIME_STRING, LocalDateTime.now());
        return new ModelAndView(placeholders, "response.json.ftl");

    }

    public static void main(String[] args) {

        // basePackagePath setting doesn't work, the only thing I could make work is when
        // the .ftl resource file is in the root folder of the "jar".
        // also if I don't set the classloader, it cannot find the .ftl file either.
        // If I pass App.class instead of the classloader, it won't find the .ftl either.

        Configuration configuration = new Configuration(new Version(2, 3, 23));
        configuration.setClassLoaderForTemplateLoading(App.class.getClassLoader(), "");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/hello/:name", App::handleGet, freeMarkerEngine);

    }

}
