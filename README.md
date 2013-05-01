# About Avalidation

AValidation is a validation framework for Android.

Start with the ["Getting started" guide](#gettingstarted) and then check out the [Java doc](http://www.blitter.se/avalidation/api/).

-------------------------------------------------------------------

<a name="gettingstarted"/>
# Getting started with AValidation
This is a guide to describe how to use AValidation when developing an Android application. The example use a simple StringValidator. See ["Different Validators"](#availablevalidators) for other validators or ["Create a Custom Validator"](#customvalidator) to create your own Validator.

## Step 1: Downloading
[Click here to download the AValidation jar](http://www.blitter.se/repo/se/blitter/android/avalidation/1.0.0/avalidation-1.0.0.jar).

## Step 2: Add AValidation to your project
Put the downloaded jar file in the "libs" directory of the android project.

## Step 3: Create a Validator
This example validates that a string has a max length of 10 characters.
```java
StringValidator commentsValidator = new StringValidator(0, 10, null, resources.getString(R.string.comment_error_max_length));
```

## Step 4: Add the validator to an `EditText`
```java
EditText editTextComment = (EditText) findViewById(R.id.editTextComment);
ValidationUtil.validateOnChange(editTextComment, commentsValidator);
```

<a name="availablevalidators"/>
# Available validators

##### Table of Contents
* [RequiredValidator](#requiredvalidator)
* [StringValidator](#stringvalidator)
* [IntegerValidator](#integervalidator)
* [ComparingMaxIntegerValidator](#comparingmaxintegervalidator)

<a name="requiredvalidator"/>
## RequiredValidator
Check that the a string is not empty.
```java
RequiredValidator requiredValidator = new RequiredValidator(resources.getString(R.string.required_error));
```

<a name="stringvalidator"/>
## StringValidator
Validates that a string is between a min and max length.
```java
new StringValidator(0, 10, null, resources.getString(R.string.error_max_length));
```

<a name="integervalidator"/>
## IntegerValidator
TODO

<a name="comparingmaxintegervalidator"/>
## ComparingMaxIntegerValidator
TODO

<a name="customvalidator"/>
# Create a custom Validator

Create a custom validator by extending the Validator class. Override the `validate` method and return null on successful validation or a String on validation error.

This example shows how the `RequiredValidator` is implemented.

```java
package se.blitter.android.validation;

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
```
