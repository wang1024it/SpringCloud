package com.wyy.microservicezuul3001.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ZuulFallBack implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 在给zuul整合回退功能时，只要类实现ZuulFallbackProvider接口，并且注册bean即可。
     *
     * 不过需要注意的时，这个回退只有服务掉线或者超时的情况下才会触发（Camden.SR4版本测试是这样），
     * 如果服务程序出现异常，此回退程序是不能处理的，异常会直接返回给调用者，比如页面。
     *
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);//application/json;charset=UTF-8
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                String msg = "服务繁忙，请稍后.....";
                //new ByteArrayInputStream("{\"code\":-1,\"msg\":\"服务暂不可用\"}".getBytes(StandardCharsets.UTF_8))
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();//400
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();//"Bad Request"
            }

            @Override
            public void close() {

            }
        };
    }
}