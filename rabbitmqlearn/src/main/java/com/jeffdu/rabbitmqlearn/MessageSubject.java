package com.jeffdu.rabbitmqlearn;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * 名称：消息模板类<br>
 * 描述：消息模板类<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Data()
public class MessageSubject<T> implements Serializable{

    /**
     * 消息类型
     */
    String messageType;

    /**
     * 消息ID
     */
    String messageId;

    /**
     * 消息内容
     */
    T content;

}
