package com.cong.asukagateway.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Slf4j
public class ResponseBodyRewrite implements RewriteFunction<String,String> {

    private ObjectMapper objectMapper;

    public ResponseBodyRewrite(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public Publisher<String> apply(ServerWebExchange exchange, String s) {
        try {
            log.info("s===========>{}",s);
            ServerHttpResponse response = exchange.getResponse();
            MediaType mediaType = response.getHeaders().getContentType();
            if (mediaType !=null){
                if (mediaType.isCompatibleWith(MediaType.APPLICATION_JSON)){
                    Map<String,Object> map = objectMapper.readValue(s, new TypeReference<Map<String, Object>>() {});
                    String url = (String)map.get("url");
                    if (StringUtils.isNotBlank(url)) {
                        String replace = url.replace("10.104.1.206", "www.congco.com");
                        map.put("url",replace);
                    }
                    return Mono.just(objectMapper.writeValueAsString(map));
                }
            }
            // 取得;
            return Mono.just(s);
        } catch (Exception ex) {
            log.error("2. json process fail", ex);
            return Mono.error(new Exception("2. json process fail", ex));
        }
    }
}
