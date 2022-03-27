package me.upp.parser.semantic.expressions;

import java.util.regex.Pattern;

public class Expressions {
    public static final Pattern PATTERN = Pattern.compile(
            "([a-zA-Z]+\\s+(\\+|\\-|\\*|\\/|=)\\s+[a-zA-Z]+)|([a-zA-Z]+(\\+|\\-|\\*|\\/|=)[a-zA-Z]+)|(([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?\\s+(\\+|\\-|\\*|\\/|=)\\s+([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?)|([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?(\\+|\\-|\\*|\\/|=)([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?",
            Pattern.CASE_INSENSITIVE
    );
}
