package com.legadi.fuga.repl.shell;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Value;

public class OutputHelper {

    @Value("${shell.out.info}")
    private String infoColor;

    @Value("${shell.out.success}")
    private String successColor;

    @Value("${shell.out.warning}")
    private String warningColor;

    @Value("${shell.out.error}")
    private String errorColor;

    private final Terminal terminal;

    public OutputHelper(Terminal terminal) {
        this.terminal = terminal;
    }

    public String wrapInfo(String message) {
        return wrapColored(message, PromptColor.valueOf(infoColor));
    }

    public String wrapSuccess(String message) {
        return wrapColored(message, PromptColor.valueOf(successColor));
    }

    public String wrapWarning(String message) {
        return wrapColored(message, PromptColor.valueOf(warningColor));
    }

    public String wrapError(String message) {
        return wrapColored(message, PromptColor.valueOf(errorColor));
    }

    protected String wrapColored(String message, PromptColor color) {
        return (new AttributedStringBuilder())
                .append(message, AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle()))
                .toAnsi();
    }

    public void print(String message) {
        printColored(message, null);
    }

    public void printSuccess(String message) {
        printColored(message, PromptColor.valueOf(successColor));
    }

    public void printInfo(String message) {
        printColored(message, PromptColor.valueOf(infoColor));
    }

    public void printWarning(String message) {
        printColored(message, PromptColor.valueOf(warningColor));
    }

    public void printError(String message) {
        printColored(message, PromptColor.valueOf(errorColor));
    }

    protected void printColored(String message, PromptColor color) {
        String toPrint = message;
        if (color != null) {
            toPrint = wrapColored(message, color);
        }
        terminal.writer().println(toPrint);
        terminal.flush();
    }
}
