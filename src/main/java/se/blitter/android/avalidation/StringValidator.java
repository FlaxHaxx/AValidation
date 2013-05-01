package se.blitter.android.avalidation;

import android.text.TextUtils;

/**
 * Validates that a String has a length within the selected range.
 * 
 * @author Jon Wikman
 */
public class StringValidator implements Validator {
    private int minLength;
    private int maxLength;
    private String minError;
    private String maxError;

    /**
     * Creates a new StringValidator.
     * 
     * @param minLength The allowed minimum length.
     * @param maxLength The allowed maximum length.
     * @param minError The error message for strings shorter then minLength.
     * @param maxError The error message for strings longer then maxLength.
     */
    public StringValidator(int minLength, int maxLength, String minError, String maxError) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minError = minError;
        this.maxError = maxError;
    }

    /**
     * Validates that a String has a length within the selected range. 
     * 
     * @param value The String to validate.
     * @return The error message or null if value validates.
     */
    @Override
    public String validate(String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }

        if (value.length() < minLength) {
            return minError;
        }

        if (maxLength >= 0 && value.length() > maxLength) {
            return maxError;
        }

        return null;
    }
}