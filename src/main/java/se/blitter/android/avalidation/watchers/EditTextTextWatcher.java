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
public class EditTextTextWatcher implements TextWatcher {
    private EditText view;
    private Validator[] validators;

    public EditTextTextWatcher(EditText view, Validator... validators) {
        this.view = view;
        this.validators = validators;
    }

    @Override
    public void afterTextChanged(Editable s) {
        String error = null;
        for(int i = 0; i < validators.length && error == null; i++) {
            error = validators[i].validate(s.toString());
        }
        view.setError(error);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
}
