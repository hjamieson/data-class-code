# Kafka Push 
A simple utility program that reads STDIN and pushes each line to a KAFKA topic.

## Assumptions
1. each line of txt is published as a single message.  Embedded crlf are not allowed.
1. text is UTF-8 characters.

## Command-line options
flag | description | example
---|---|---
-t | topic | -t foobar
-b | bootstrap HOSTNAME:PORT.  Can be abbreviated as :PORT | -b localhost:9092
||| -b :9092 
-h | hostname | -h localhost
-p | port | -p 1234

## Observations
1. Ran this many times with ZERO output to kafka.  wtf?  discovered that if you are running from gradle using `./gradle run`, you must tell gradle that you want stdin connected to the run input.  If you look at the build.gradle file, you can see where I enabled this.
1. The current kafka docker setup is listening on 9092 on the data network, but 19092 on the localhost network.  I'll see if I can finesse this.