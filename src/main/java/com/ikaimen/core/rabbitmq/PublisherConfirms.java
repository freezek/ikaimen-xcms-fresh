package com.ikaimen.core.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/5/19.
 */
public class PublisherConfirms {

    private static final String QUEUE_NAME = "publisher-confirms";

    private static final int MSG_COUNT = 10;

    private static ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setHost("*.*.*.*");
        factory.setPort(5672);
        factory.setUsername("xxxx");
        factory.setPassword("xxxx");
    }


    public static void main(String[] args) throws Exception {

        // Publish MSG_COUNT messages and wait for confirms.
        (new Thread(new Consumer())).start();
        // Consume MSG_COUNT messages.
        (new Thread(new Publisher())).start();

    }

    static class Publisher implements Runnable {

        volatile SortedSet<Long> ackSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        public void run() {
            try {
                long startTime = System.currentTimeMillis();

                // 创建一个新的连接
                Connection connection = factory.newConnection();
                // 创建一个频道
                Channel channel = connection.createChannel();

                channel.queueDeclare(QUEUE_NAME, true, false, false, null);

                channel.confirmSelect();

                channel.addConfirmListener(new ConfirmListener() {
                    public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                        if (multiple) {
                            for (long i = ackSet.first(); i <= deliveryTag; ++i) {
                                System.out.println("handle ack multiple, tag : " + deliveryTag);
                                ackSet.remove(i);
                            }
                        } else {
                            System.out.println("handle ack, tag : " + deliveryTag);
                            ackSet.remove(deliveryTag);
                        }
                    }

                    public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                        System.out.println("handle nack, tag : " + deliveryTag);
                    }
                });

                // Publish
                for (long i = 0; i < MSG_COUNT; ++i) {
                    ackSet.add(i);
                    channel.basicPublish("", QUEUE_NAME,
                            MessageProperties.PERSISTENT_TEXT_PLAIN,
                            "欢迎投注！".getBytes());
                }

                // Wait
                while (ackSet.size() > 0)
                    Thread.sleep(10);

                // Cleanup
                channel.close();
                connection.close();

                long endTime = System.currentTimeMillis();
                System.out.printf("Test took %.3fs\n", (float) (endTime - startTime) / 1000);

            } catch (Throwable e) {
                System.out.println("foobar :(");
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        public void run() {
            try {
                // Setup
                Connection conn = factory.newConnection();
                Channel ch = conn.createChannel();
                ch.queueDeclare(QUEUE_NAME, true, false, false, null);

                // Consume
                QueueingConsumer qc = new QueueingConsumer(ch);
                ch.basicConsume(QUEUE_NAME, true, qc);
                for (int i = 0; i < MSG_COUNT; ++i) {
                    QueueingConsumer.Delivery delivery = qc.nextDelivery();
                    System.out.println("got msg : " + new String(delivery.getBody())+i);
                    if(i==5){
                        throw new RuntimeException("异常模拟消息丢失！");
                    }
                }

                // Consume
                ch.close();
                conn.close();
            } catch (Throwable e) {
                System.out.println("Whoosh!");
                e.printStackTrace();
            }
        }
    }

}
