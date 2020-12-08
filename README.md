### Tema final 1

**Tema - Jetty: Calculadora com Spring**

```
Deploy da Calculadora com Spring utilizando JETTY.
``` 
**Passo a Passo para utilizar a aplicação:**

- Inicializando a aplicação com o Jetty
``` 
Abra o terminal no diretório da aplicação e insira o comando ./calculator.sh run-app
Confira em "localhost:8080"
Pronto, a aplicação já está rodando, agora vamos utilizá-la.
Para parar a aplicação basta inserir o comando ctrl + c
```
- Utilizando a calculadora no JETTY
``` 
Insira os valores em X, Y e Z: localhost:8080/calculator?num1=X&op=Y&num2=Z
Utilizar as operações a seguir:
 + => %2B (Utilizar % junto ao código hexadecimal 2B devido ao caractere especial "+" ser reservado)
 - 
 /
 *
 pow

Para acessar o histórico da calculadora, insira a url localhost:8080/calculator?history
```

**Referências de estudo e desenvolvimento:**

- Vídeo Aula - Tema 04: Jetty
- https://docs.gradle.org/current/userguide/war_plugin.html
- https://www.eclipse.org/jetty/documentation/9.4.32.v20200930/
- https://www.eclipse.org/jetty/download.html 
- https://sempreupdate.com.br/descompactar-arquivos-zip-rar-tar-gz-bz2-tar-bz2-no-linux/
