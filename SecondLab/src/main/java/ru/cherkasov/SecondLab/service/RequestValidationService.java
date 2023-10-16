package ru.cherkasov.SecondLab.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.cherkasov.SecondLab.exception.UnsupportedCodeException;
import ru.cherkasov.SecondLab.exception.ValidationFailedException;
import ru.cherkasov.SecondLab.service.ValidationService;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }

        String uid = (String) bindingResult.getFieldValue("uid");
        if ("123".equals(uid)) {
            throw new UnsupportedCodeException(123);
        }
    }
}
