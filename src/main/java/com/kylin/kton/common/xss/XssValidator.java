/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.ConstraintValidator
 *  javax.validation.ConstraintValidatorContext
 */
package com.kylin.kton.common.xss;

import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.xss.Xss;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class XssValidator
implements ConstraintValidator<Xss, String> {
    private static final String HTML_PATTERN = "<(\\S*?)[^>]*>.*?|<.*? />";

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank((CharSequence)value)) {
            return true;
        }
        return !XssValidator.containsHtml(value);
    }

    public static boolean containsHtml(String value) {
        StringBuilder sHtml = new StringBuilder();
        Pattern pattern = Pattern.compile(HTML_PATTERN);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            sHtml.append(matcher.group());
        }
        return pattern.matcher(sHtml).matches();
    }
}

