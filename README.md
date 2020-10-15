# Projeto Kafka producer & consumer

Neste projeto será desenvolvido um producer para o envio de mensagem ao Kafka e também um consumer para consumo das mensagens.


Download Kafka: https://downloads.apache.org/kafka/2.6.0/kafka-2.6.0-src.tgz

Download Kafka Tool: https://www.kafkatool.com/download.html

Após baixar e configurar a variável de ambiente do kafka, execute a sequência de comandos
abaixo para iniciar e criar tópico e fila

Start zookeeper-server
```
zookeeper-server-start.bat C:\SmartProjects\kafka\config\zookeeper.properties
```

Start kafka-server
```
kafka-server-start.bat C:\SmartProjects\kafka\config\server.properties
```

Cria o topic topic-mensagem:
```
kafka-topics --bootstrap-server localhost:9092 --create --topic topic-mensagem
```

Cria um consumer para topic topic-mensagem:
```
kafka-console-consumer --bootstrap-server localhost:9092  --topic topic-mensagem --from-beginning
```
