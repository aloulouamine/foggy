package aaloulou.com.foggy.handler;

import aaloulou.com.foggy.dto.User;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FoggyHandler {

    private final static Faker faker = new Faker(Locale.FRENCH);

    public Mono<ServerResponse> getUser(final ServerRequest request, final MediaType mediaType) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(new User(
                FoggyHandler.faker.name().fullName(),
                FoggyHandler.faker.date().birthday().toString(),
                FoggyHandler.faker.bothify("????##@gmail.com"),
                FoggyHandler.faker.phoneNumber().cellPhone(),
                FoggyHandler.faker.finance().iban(),
                FoggyHandler.faker.finance().bic()
        ));
    }
}
