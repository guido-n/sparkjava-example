guido@guido-Latitude-E5470:~/Source/sparkjava-attempt$ java -jar target/sparkjava-attempt-1.0-SNAPSHOT.jar 
INFO  2018-03-09 11:42:23,480 [Thread-1] org.eclipse.jetty.util.log: Logging initialized @474ms to org.eclipse.jetty.util.log.Slf4jLog
INFO  2018-03-09 11:42:23,519 [Thread-1] spark.embeddedserver.jetty.EmbeddedJettyServer: == Spark has ignited ...
INFO  2018-03-09 11:42:23,519 [Thread-1] spark.embeddedserver.jetty.EmbeddedJettyServer: >> Listening on 0.0.0.0:4567
INFO  2018-03-09 11:42:23,522 [Thread-1] org.eclipse.jetty.server.Server: jetty-9.4.z-SNAPSHOT, build timestamp: 2017-11-21T21:27:37Z, git hash: 82b8fb23f757335bb3329d540ce37a2a2615f0a8
INFO  2018-03-09 11:42:23,543 [Thread-1] org.eclipse.jetty.server.session: DefaultSessionIdManager workerName=node0
INFO  2018-03-09 11:42:23,543 [Thread-1] org.eclipse.jetty.server.session: No SessionScavenger set, using defaults
INFO  2018-03-09 11:42:23,546 [Thread-1] org.eclipse.jetty.server.session: Scavenging every 660000ms
INFO  2018-03-09 11:42:23,562 [Thread-1] org.eclipse.jetty.server.AbstractConnector: Started ServerConnector@428a81dd{HTTP/1.1,[http/1.1]}{0.0.0.0:4567}
INFO  2018-03-09 11:42:23,562 [Thread-1] org.eclipse.jetty.server.Server: Started @559ms
INFO  2018-03-09 11:42:54,579 [qtp234473910-13] com.guido.App: Received: GET http://localhost:4567/hello/guido
INFO  2018-03-09 11:42:59,961 [qtp234473910-18] com.guido.App: Received: GET http://localhost:4567/hello/bjss

guido@guido-Latitude-E5470:~$ curl http://localhost:4567/hello/guido
{
    "greeting": "Ciao guido!",
    "received-at": "2018-03-09T11:42:54.594"
}
guido@guido-Latitude-E5470:~$ curl http://localhost:4567/hello/bjss
{
    "greeting": "Ciao bjss!",
    "received-at": "2018-03-09T11:42:59.961"
}
guido@guido-Latitude-E5470:~$ 

IMPORTANT used maven shade plugin both to create a shaded jar and an EXECUTABLE JAR (updated manifest file)
