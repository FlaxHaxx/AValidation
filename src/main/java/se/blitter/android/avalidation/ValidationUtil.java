package se.blitter.android.avalidation;

import se.blitter.android.avalidation.watchers.EditTextTextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;

/**
 * Contains helpful methods when working with validation.
 * 
 * @author Jon Wikman
 */
public class ValidationUtil {
    /**
     * Puts a watcher on editText and validates the content whenever it changes.
     * 
     * @param editText The view to validate when it changes.
     * @param validators The validators to use when validating.
     */
    public static void validateOnChange(final EditText editText, final Validator... validators) {
        editText.addTextChangedListener(new EditTextTextWatcher(editText, validators));
        editText.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    CharSequence error = null;
                    for (int i = 0; i < validators.length && error == null; i++) {
                        error = validators[i].validate(editText.getText().toString());
                    }
                    editText.setError(error);
                }
                return false;
            }
        });
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    CharSequence error = null;
                    for (int i = 0; i < validators.length && error == null; i++) {
                        error = validators[i].validate(editText.getText().toString());
                    }
                    editText.setError(error);
                }
            }
        });
    }
}
