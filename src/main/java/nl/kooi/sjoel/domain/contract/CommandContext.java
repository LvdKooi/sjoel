package nl.kooi.sjoel.domain.contract;

import nl.kooi.sjoel.domain.ValidatorService;

public interface CommandContext {

    ValidatorService getValidatorService();
}
