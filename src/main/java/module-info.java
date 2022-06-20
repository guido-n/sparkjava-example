module sparkjava.example {

    exports com.guido.sparkjavaexample;

    requires java.sql;

    requires freemarker;

    requires spark.core;
    requires spark.template.freemarker;

    requires org.apache.logging.log4j;

}