FROM mysql
LABEL maintainer="Marcos Aurélio"
EXPOSE 3306
ENV MYSQL_ROOT_PASSWORD="senha" MYSQL_USER="marcos" MYSQL_PASSWORD="senha" MYSQL_DATABASE="livro"
