# Maratona JSF AlgaWorks.
##### Estudo de JSF, JPA E HIBERNATE 🚧

## Configurar o tomcat na IDE Eclipse. 🐈
A versão útilizada será a 9.0.80 x64 [Download Tomcat.](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80-windows-x64.zip)

Descompacte e começaremos abilitando a aba Server na IDE.

```
Window > Show view > Server
```

Após isso clicar em `Click this link to create a new server` e selecionar `Tomcat v9.0 Server` e em `Next`.

Clicar em Browse e localizar a pasta onde o `Tomcat` foi descompactado e selecione.

Em `JRE` selecione a sua versão do JDK e clique em `Finish`.

Agora de um duplo clique no server e clique em `Open launch configuration` e em `Arguments` inclua na aba `VM arguments` `-Xms256m -Xmx512m` para limitar o consumo de mémoria do Tomcat finalize em `Ok`.

Na aba `Server Locations` clique em `Use Tomcat installation`.
Mais a baixo na aba `Server Options` desmarque a opção `Modules auto reload by default`.


## Configurar o Apache Maven Project na IDE Eclipse. 🍃
New > Project > pesquise por Maven e clique em `Maven Project`.

Agora selecione `Create a simple project`, pode selecionar um local do projeto novo ou apenas clicar em `Next`.

Para essa parte será preenchido o *Group Id*, *Artifact Id* , *Name*, *Description* e em *Packaging* selecione `WAR` e `Finish`.

Agora é resolver algum erro apontado pelo `Pom.xml` ou `Deployment` do projeto!

## Configurando as dependencias. 📂

No Pom.xml inclua dentro da tag `<dependencies> </dependencies>`

##### JSF ✔️
```sh 
        <dependency>
            <groupId>org.glassfish</groupId>
            <artifactId>javax.faces</artifactId>
            <version>2.3.9</version>
            <scope>compile</scope>
        </dependency>
```
##### PRIMEFACES ✔️
```
        <dependency>
            <groupId>org.primefaces</groupId>
            <artifactId>primefaces</artifactId>
            <version>12.0.0</version>
            <scope>compile</scope>      
        </dependency>
```

##### JAKARTA SERVLET ✔️
```
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.0.0</version>
            <scope>provided</scope>
        </dependency>
```

##### ~~HIBERNATE VALIDATOR REMOVIDO POR COMFLITO~~ ❌
```
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>8.0.0.Final</version>
            <scope>compile</scope>
        </dependency>
```

##### PERSISTENCIA HIBERNATE ✔️
```
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.6.15.Final</version>
            <scope>compile</scope>
        </dependency>
```

##### MYSQL ✔️
```
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
            <scope>compile</scope>
        </dependency>
```

## Configuracoes adicionais 🛠️

Caso esteja clonando o repositório uma primeira vez, abra o arquivo `Persistence.xml` altere as informações de seu banco de dados e descomente as linhas abaixo para rodar o `dados-iniciais.sql` executando a classe `SchemaGeneration.java`.

```
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/dados-iniciais.sql"/>
```
