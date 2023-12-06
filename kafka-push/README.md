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