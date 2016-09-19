<?xml version="1.0" encoding="UTF-8"?>
<!-- configuration file for LogBack (slf4J implementation)
See here for more details: http://gordondickens.com/wordpress/2013/03/27/sawing-through-the-java-loggers/ -->
<configuration scan="true" scanPeriod="30 seconds">
    <contextListener class="ch.qos.logback.classic.jul.LevelChangePropagator">
        <resetJUL>true</resetJUL>
    </contextListener>

    <!-- To enable JMX Management -->
    <jmxConfigurator />

    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${PID}: %-5level %logger{0} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Specify logging levels -->
    <logger name="org.springframework" level="warn"/>
 	<logger name="org.hibernate" level="warn"/>
         
    <root level="debug">
        <appender-ref ref="console"/>
    </root>
</configuration>
