# Maratona JSF AlgaWorks.
###### Estudo de JSF, JPA E HIBERNATE

### Apache Tomcat.
A versão útilizada será a 9.0.80 x64 [Download Tomcat.](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80-windows-x64.zip)

### Configurar o tomcat na IDE Eclipse.
Abilitando a aba Server na IDE.
```
Window > Show view > Server
```

Após isso clicar em `Click this link to create a new server` e selecionar `Tomcat v9.0 Server` e em `Next`.

Clicar em Browse e localizar a pasta onde o `Tomcat` foi descompactado e selecione.

Em `JRE` selecione a sua versão do JDK e clique em `Finish`.

Agora de um duplo clique no server e clique em `Open launch configuration` e em `Arguments` inclua na aba `VM arguments` `-Xms256m -Xmx512m` para limitar o consumo de mémoria do Tomcat finalize em `Ok`.

Na aba `Server Locations` clique em `Use Tomcat installation`.
Mais a baixo na aba `Server Options` desmarque a opção `Modules auto reload by default`.


### Apache Maven Project.
Usaremos o Maven nativo da IDE sem a necessidade de download.

### Configurar o Apache Maven Project na IDE Eclipse.
New > Project > pesquise por Maven e clique em `Maven Project`.

Agora selecione `Create a simple project`, pode selecionar um local do projeto novo ou apenas clicar em `Next`.

Para essa parte será preenchido o *Group Id*, *Artifact Id* , *Name*, *Description* e em *Packaging* selecione `WAR` e `Finish`.

## Projeto configurado!
Agora é resolver algum erro apontado pelo `Pom.xml` ou `Deployment`!

