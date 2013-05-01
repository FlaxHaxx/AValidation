package se.blitter.android.avalidation.watchers;

import se.blitter.android.avalidation.Validator;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Remember to run init() before using this class?
 * 
 * @author Jon Wikman
 */
public class EditTextValidationActivater implements TextWatcher {
    private EditText view;
    private Validator validator;

    public EditTextValidationActivater(EditText view, Validator validator) {
        this.view = view;
        this.validator = validator;
    }

    @Override
    public void afterTextChanged(Editable s) {
        view.setError(validator.validate(view.getText().toString()));
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
}
