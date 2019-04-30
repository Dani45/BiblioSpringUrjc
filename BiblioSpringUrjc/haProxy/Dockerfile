FROM haproxy:1.9.6
COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
RUN mkdir -p /etc/ssl/xip.io/
COPY xip.io.pem /etc/ssl/xip.io/
RUN chmod 777 /etc/ssl/xip.io/xip.io.pem