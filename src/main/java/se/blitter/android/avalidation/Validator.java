package se.blitter.android.avalidation;

/**
 * The Validation interface all validators.
 * 
 * @author Jon Wikman
 */
public interface Validator {
    /**
     * Validates the value.
     * 
     * @param value The value to validate.
     * @return The error message or null if value is valid.
     */
    public String validate(String value);
}
