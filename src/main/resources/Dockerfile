FROM tomcat

#变量
ARG myname=qmf

#制定作者和元数据标签
MAINTAINER $myname
LABEL author=qmf

#复制文件到镜像
COPY *.war /usr/local/tomcat/webapps
#复制，文件为压缩文件是，会被解压
#ADD *.war /usr/local/tomcat/webapps

#配置环境变量
ENV JAVA_HOME /usr/local/jdk8
ENV CLASSPATH .:$JAVA_HOME/lib
ENV CATALINA_HOME /usr/local/tomcat7
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin

#工作目录
WORKDIR $CATALINA_HOME

RUN yum -y install vim

#宿主机挂载目录
VOLUME ["/usr/local/dev"]

#暴露端口
EXPOSE 8080

CMD ls

ENTRYPOINT ["/bin/catalina.sh","run"]



