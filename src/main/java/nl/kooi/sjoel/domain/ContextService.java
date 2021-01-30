package nl.kooi.sjoel.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.contract.CommandContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContextService implements CommandContext {
    @Getter
    private final ValidatorService validatorService;
    
}
