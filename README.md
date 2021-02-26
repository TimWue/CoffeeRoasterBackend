# CoffeeRoasterBackend
Java Spring Backend for the Coffee-Roaster application, including Stomp Messaging over Websocket and REST-API to post, get and delete roasts.
In addition you need the following:
  - mysql database
  - application.properties in /src/main/resources to define
    - spring.jpa.hibernate.ddl-auto
    - spring.datasource.url
    - spring.datasource.username
    - spring.datasource.password
  - additional java dependency for modbus - support (https://sourceforge.net/projects/easymodbustcp-udp-java/files/latest/download)
  - temperatur sensor using modbus-tcp
