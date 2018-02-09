package person.cznno.vertxservice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by cznno
 * Date: 18-2-9
 */
public class FirstVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        super.start();
        vertx.createHttpServer().requestHandler(router()::accept).listen(8081);
    }

    private Router router() {
        Router router = Router.router(vertx);
        router.get("/").handler(rc->rc.response().end("hello"));
        router.route("/info").handler(routingContext -> {

            HttpServerResponse response = routingContext.response();

            response.putHeader("Content-Type", "application/json");
            response.end(new JsonObject().put("hello", "foo").encode());
        });
        return router;
    }
}
