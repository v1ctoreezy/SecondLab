package ru.cherkasov.SecondLab.exception;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
