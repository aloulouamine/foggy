package aaloulou.com.foggy.router;

import aaloulou.com.foggy.handler.FoggyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@Component
@RequiredArgsConstructor
public class FoggyRouter {

    private final FoggyHandler foggyHandler;

    @Bean
    public RouterFunction<ServerResponse> router() {
        return route().nest(
                path("/api"),
                builder -> builder.nest(
                        path("/user"),
                        nestedBuilder -> nestedBuilder.GET("", accept(MediaType.APPLICATION_JSON), request -> this.foggyHandler.getUser(request, MediaType.APPLICATION_JSON))
                )
        ).build();
    }
}