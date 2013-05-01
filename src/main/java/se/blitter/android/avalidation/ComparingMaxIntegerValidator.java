package se.blitter.android.avalidation;

import se.blitter.android.avalidation.watchers.EditTextValidationActivater;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Validates that a String is an integer is between a minimum value and a maximum value. The maximum value is determined by the value of a
 * TextView.
 * 
 * @author Jon Wikman
 */
public class ComparingMaxIntegerValidator implements Validator {
    private int minValue;
    private TextView viewWithMaxValue;
    private String minError;
    private String maxError;
    private String nanError;

    /**
     * Creates a new ComparingMaxIntegerValidator.
     * 
     * @param targetView The view which content will be validated when viewWithMaxValue's content changes.
     * @param minValue The allowed minimum value.
     * @param viewWithMaxValue The view containing the maximum allowed value.
     * @param minError The error message for values lower then minValue.
     * @param maxError The error message for values higher then maxValue.
     * @param nanError The error message for values that are not a number or not in the range for an Integer.
     */
    public ComparingMaxIntegerValidator(EditText targetView, int minValue, TextView viewWithMaxValue, String minError, String maxError, String nanError) {
        this.minValue = minValue;
        this.viewWithMaxValue = viewWithMaxValue;
        this.minError = minError;
        this.maxError = maxError;
        this.nanError = nanError;

        viewWithMaxValue.addTextChangedListener(new EditTextValidationActivater(targetView, this));
    }

    /**
     * Validates that the target view has a value between the minimum value and the value of the watched view.
     * 
     * @param value The String to validate.
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

            if (intValue > Integer.parseInt(viewWithMaxValue.getText().toString())) {
                return maxError;
            }
        } catch (NumberFormatException e) {
            return nanError;
        }

        return null;
    }
}
