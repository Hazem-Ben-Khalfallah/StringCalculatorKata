package com.blacknebula.kata;

import java.util.List;

class Parser {
    private String expression;
    private List<String> separators;

    public Parser() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<String> getSeparators() {
        return separators;
    }

    public void setSeparators(List<String> separators) {
        this.separators = separators;
    }
}