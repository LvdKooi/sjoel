package nl.kooi.sjoel.domain;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.exception.SjoelpuntenException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidatorService {
    private final Validator validator;

    public <T> T validate(T object) {
        var messages = validator.validate(object)
                .stream()
                .map(ValidatorService::messageFor)
                .sorted()
                .collect(Collectors.joining("\n"));

        if (messages.isEmpty()) {
            return object;
        }
        throw new SjoelpuntenException(messages);
    }

    private static String messageFor(ConstraintViolation<?> violation) {
        var propertyPath = violation.getPropertyPath().toString();
        if (Strings.isEmpty(propertyPath)) {
            return violation.getMessage();
        }
        if (!violation.getMessage().contains("{propertyPath}")) {
            return String.format("'%s' %s", propertyPath, violation.getMessage());
        }
        return violation.getMessage().replaceAll("\\{propertyPath\\}", propertyPath);
    }
}
