package net.kingsilk.qh.shop.msg.api.search.ItemsImport.sync;

import net.kingsilk.qh.shop.msg.Q;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        exclusive = "true",
                        autoDelete = "true"
                ),
                exchange = @Exchange(
                        value = Q.MQ_EXCHANGE_PREFIX
                                + "."
                                + Q._PKG_API + ".search.itemImport.sync.ImportSyncEvent",
                        type = ExchangeTypes.FANOUT,
                        durable = "true"
                )
        )
)
public @interface ImportSyncListener {

}