module sparkjava.example.test {

    exports com.guido.sparkjavaexample.test;

    requires sparkjava.example;

    requires org.junit.jupiter;
    requires org.hamcrest;

    requires rest.assured;

    requires spark.core;

}