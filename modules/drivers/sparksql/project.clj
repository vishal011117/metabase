(defproject metabase/sparksql-driver "1.0.0"
  :min-lein-version "2.5.0"

  :dependencies
  [
   ;; Exclusions below are all either things that are already part of metabase-core or part of both hadoop-common and
   ;; hive-jdbc, which begs the question: do we need hadoop-common? Adds about 16MB to the driver size. Although it's
   ;; not a huge difference since it takes the driver from 130 MB to 146 MB. ENORMOUS either way.
   [org.apache.hadoop/hadoop-common "3.1.1"
    :exclusions [com.fasterxml.jackson.core/jackson-core
                 com.google.guava/guava
                 commons-logging
                 org.apache.httpcomponents/httpcore
                 org.codehaus.jackson/jackson-core-asl
                 org.codehaus.jackson/jackson-mapper-asl
                 org.eclipse.jetty/jetty-http
                 org.eclipse.jetty/jetty-io
                 org.eclipse.jetty/jetty-server
                 org.eclipse.jetty/jetty-util
                 org.slf4j/slf4j-log4j12
                 org.tukaani/xz]]
   [org.apache.hive/hive-jdbc "3.1.1"
    :exclusions [com.fasterxml.jackson.core/jackson-annotations
                 com.fasterxml.jackson.core/jackson-core
                 com.fasterxml.jackson.core/jackson-databind
                 com.google.code.findbugs/jsr305
                 com.google.guava/guava
                 com.google.inject/guice
                 commons-cli
                 commons-logging
                 io.dropwizard.metrics/metrics-core
                 javax.xml.bind/jaxb-api
                 jetty/jetty-servlet
                 jline
                 org.apache.commons/commons-compress
                 org.apache.commons/commons-lang3
                 org.apache.commons/commons-math3
                 org.apache.curator/curator-client
                 org.apache.curator/curator-framework
                 org.apache.hadoop/hadoop-hdfs
                 org.apache.httpcomponents/httpcore
                 org.apache.kafka/kafka_2.10
                 org.apache.logging.log4j/log4j-slf4j-impl
                 org.apache.zookeeper/zookeeper
                 org.codehaus.jackson/jackson-core-asl
                 org.codehaus.jackson/jackson-jaxrs
                 org.codehaus.jackson/jackson-mapper-asl
                 org.codehaus.jackson/jackson-xc
                 org.codehaus.jettison/jettison
                 org.eclipse.jetty/jetty-http
                 org.eclipse.jetty/jetty-io
                 org.eclipse.jetty/jetty-security
                 org.eclipse.jetty/jetty-server
                 org.eclipse.jetty/jetty-servlet
                 org.eclipse.jetty/jetty-util
                 org.eclipse.jetty/jetty-util-ajax
                 org.eclipse.jetty/jetty-webapp
                 org.eclipse.jetty/jetty-xml
                 org.glassfish/javax.el
                 org.jamon/jamon-runtime
                 org.ow2.asm/asm-all
                 org.slf4j/slf4j-api
                 org.slf4j/slf4j-log4j12]]]

  :jvm-opts
  ["-XX:+IgnoreUnrecognizedVMOptions"
   "--add-modules=java.xml.bind"]

  :profiles
  {:provided
   {:dependencies [[metabase-core "1.0.0-SNAPSHOT"]]}

   :uberjar
   {:auto-clean    true
    :aot           :all
    :javac-options ["-target" "1.8", "-source" "1.8"]
    :target-path   "target/%s"
    :uberjar-name  "sparksql.metabase-driver.jar"}})
