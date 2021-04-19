package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.service.ValidatorService;

public interface CommandContext {

    ValidatorService getValidatorService();
}
