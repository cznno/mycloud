package person.cznno.vertxservice;

import io.vertx.core.Vertx;

/**
 * Created by cznno
 * Date: 18-2-9
 */
public class VertxApplication {

    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new FirstVerticle());
        vertx.deployVerticle(new HelloConsumerMicroService());
    }
}
