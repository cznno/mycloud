package person.cznno.vertxservice;

import io.vertx.core.Vertx;

/**
 * Created by cznno
 * Date: 18-2-9
 */
public class VertxApplication {

    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();
        System.out.println(1);
        vertx.deployVerticle(new FirstVerticle());
        System.out.println(2);
        vertx.deployVerticle(new HelloConsumerMicroService());
        System.out.println(3);
    }
}
