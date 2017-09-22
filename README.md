# About AValidation

AValidation is a validation framework for Android. AValidation is an easy way to validate an `EditText` when the content changes. An error icon and optional message will be displayed if there is a validation error.

It can also compare the content of an `EditText` with content of another `EditText` when validating (see [ComparingMaxIntegerValidator](#comparing-max-integer-validator)).

The same validators can also be used to validate the entire form.

Start with the ["Getting started" guide](#getting-started-with-avalidation) and then check out the [Javadoc](http://www.blitter.se/avalidation/api/).

## Getting started with AValidation
This is a guide to describe how to use AValidation when developing an Android application. The example use a simple StringValidator. See ["Different Validators"](#available-validators) for other validators or ["Create a Custom Validator"](#custom-validator) to create your own Validator.

__Step 1: Downloading__

[Click here to download the AValidation jar](http://www.blitter.se/repo/se/blitter/android/avalidation/1.0.0/avalidation-1.0.0.jar).

__Step 2: Add AValidation to your project__

Put the downloaded jar file in the "libs" directory of the android project.

__Step 3: Create a `Validator`__

This example validates that a string has a max length of 10 characters.
```java
StringValidator commentsValidator = new StringValidator(0, 10, null, resources.getString(R.string.comment_error_max_length));
```

__Step 4: Add the `Validator` to an `EditText`__

```java
EditText editTextComment = (EditText) findViewById(R.id.editTextComment);
ValidationUtil.validateOnChange(editTextComment, commentsValidator);
```

## Available Validators

__Table of Contents__
* [RequiredValidator](#requiredvalidator)
* [StringValidator](#stringvalidator)
* [IntegerValidator](#integervalidator)
* [ComparingMaxIntegerValidator](#comparingmaxintegervalidator)

### RequiredValidator
Check that a string is not empty.
```java
new RequiredValidator(resources.getString(R.string.required_error));
```

### StringValidator
Validates that a string is between a min and max length.
```java
new StringValidator(0, 10, null, resources.getString(R.string.error_max_length));
```

### IntegerValidator
TODO

### ComparingMaxIntegerValidator
TODO

## Create a custom Validator

Create a custom validator by implementing the `Validator` interface. Override the `validate` method and return null on successful validation or a String on validation error.

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
