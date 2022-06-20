package com.guido;

import freemarker.template.Configuration;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;

/**
 * @see <a href="https://github.com/perwendel/spark-template-engines/tree/master/spark-template-freemarker">spark-template-freemarker</a>
 * @see /home/guido/.m2/repository/com/sparkjava/spark-template-freemarker/2.7.1/spark-template-freemarker-2.7.1-sources.jar!/spark/template/freemarker/FreeMarkerEngine.java:32
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static final String GREETING_STRING = "greetingString";
    public static final String NOW_TIME_STRING = "nowTimeString";

    private static ModelAndView handleGet(Request req, Response res) {

        LOG.info("Received: {} {}", req.requestMethod(), req.url());
        res.header("Content-Type", "application/json");
        Map<String, Object> placeholders = new HashMap<>();
        placeholders.put(GREETING_STRING, "Ciao " + req.params(":name") + "!");
        placeholders.put(NOW_TIME_STRING, LocalDateTime.now());
        return new ModelAndView(placeholders, "response.json.ftl");

    }

    public static void main(String[] args) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        configuration.setClassForTemplateLoading(App.class, "/template");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/hello/:name", App::handleGet, freeMarkerEngine);

    }

}
