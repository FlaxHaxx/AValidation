package se.blitter.android.avalidation;

import android.text.TextUtils;

/**
 * Validates that an integer is between a minimum value and a maximum value.
 * 
 * @author Jon Wikman
 */
public class IntegerValidator implements Validator {
    private int minValue;
    private int maxValue;
    private String minError;
    private String maxError;
    private String nanError;

    /**
     * Creates a new IntegerValidator.
     * 
     * @param minValue
     *            The allowed minimum value.
     * @param maxValue
     *            The allowed maximum value.
     * @param minError
     *            The error message for values lower then minValue.
     * @param maxError
     *            The error message for values higher then maxValue.
     * @param nanError
     *            The error message for values that are not a number or not in the range for an Integer.
     */
    public IntegerValidator(int minValue, int maxValue, String minError, String maxError, String nanError) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minError = minError;
        this.maxError = maxError;
        this.nanError = nanError;
    }

    /**
     * Validates that a String is a valid integer within the selected range.
     * 
     * @param value
     *            The String to validate.
     * @return The error message or null if value validates.
     */
    @Override
    public String validate(String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }

        try {
            int intValue = Integer.parseInt(value);

            if (intValue < minValue) {
                return minError;
            }

            if (intValue > maxValue) {
                return maxError;
            }
        } catch (NumberFormatException e) {
            return nanError;
        }

        return null;
    }
}
