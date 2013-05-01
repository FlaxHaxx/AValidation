package se.blitter.android.avalidation;

import android.text.TextUtils;

/**
 * Validates that a String is not empty.
 * 
 * @author Jon Wikman
 */
public class RequiredValidator implements Validator {
    private String requiredError;

    /**
     * Creates a new RequiredValidator.
     */
    public RequiredValidator(String requiredError) {
        this.requiredError = requiredError;
    }

    /**
     * Validates that a String is not empty.
     * 
     * @param value
     *            The String to validate.
     * @return The error message if value is empty otherwise null.
     */
    @Override
    public String validate(String value) {
        return TextUtils.isEmpty(value) ? requiredError : null;
    }
}
