package org.jsmart.zerocode.core.engine.assertion;

public class FieldHasSubStringIgnoreCaseValueAsserter implements JsonAsserter {
    private final String path;
    private final String expected;

    public FieldHasSubStringIgnoreCaseValueAsserter(String path, String expected) {
        this.path = path;
        this.expected = expected;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public AssertionReport actualEqualsToExpected(Object actualValue) {
        boolean areEqual;
        if (actualValue instanceof String && expected instanceof String) {
            String s1 = (String) actualValue;
            String s2 = expected;
            areEqual = s1.toUpperCase().contains(s2.toUpperCase());
        } else {
            areEqual = false;
        }

        return areEqual ?
                AssertionReport.createFieldMatchesReport() :
                AssertionReport.createFieldDoesNotMatchReport(path, "containing sub-string with ignoring case:" + expected, actualValue);
    }
}