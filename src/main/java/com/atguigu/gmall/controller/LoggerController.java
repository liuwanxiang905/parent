package com.atguigu.gmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@Slf4j //todo 会生产一个变量 log
public class LoggerController {
    @Autowired //todo 注入
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/applog")
    public String logger(@RequestParam("param") String jsonLog){
        //todo 打印到控制台
//        System.out.println(jsonLog);
        //todo 落盘
        log.info(jsonLog);
        //todo 发送到kafka
//        Properties prop = new Properties();
//        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.10.101:9092");
//        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "");
//        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "");
//        prop.setProperty(ProducerConfig.ACKS_CONFIG, "");
//        prop.setProperty();
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        kafkaTemplate.send("ods_base_log", jsonLog);
        return "success";
    }
}
