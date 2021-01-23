package com.example.tcpdemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.netty.NettyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends RouteBuilder {

    @Autowired
    private ResponseMessage responseMessage;

    @Override
    public void configure() throws Exception {

        from("netty:tcp://0.0.0.0:5150?sync=true")
                .process(exchange -> {

                    System.out.println("---------   exchange.getIn().getBody() : ----------");
                    System.out.println(exchange.getIn().getBody());

                    System.out.println("---------   exchange.getIn().getHeaders : ----------");
                    System.out.println(exchange.getIn().getHeaders());

                    // exchange.getOut().setBody("Terkkuja tcp-kamelilta !!\n");
                    exchange.getOut().setBody(responseMessage.getResponseMessage() + "\n");
                    exchange.getOut().setHeader(NettyConstants.NETTY_CLOSE_CHANNEL_WHEN_COMPLETE, true);
                    System.out.println("CAMEL.NETTY response : " + exchange.getOut().getBody());
        });
    }
}
