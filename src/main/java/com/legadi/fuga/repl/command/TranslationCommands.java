package com.legadi.fuga.repl.command;

import java.util.Locale;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.legadi.fuga.repl.shell.OutputHelper;

@ShellComponent
public class TranslationCommands {

    private final OutputHelper outputHelper;
    
    public TranslationCommands(OutputHelper outputHelper) {
        this.outputHelper = outputHelper;
    } 

    @ShellMethod("Translate text from one language to another.")
    public String translate(
            @ShellOption String text,
            @ShellOption(defaultValue = "en_US") Locale from,
            @ShellOption Locale to) {
        outputHelper.print("defaut");
        outputHelper.printError("error");
        outputHelper.printInfo("info");
        outputHelper.printSuccess("success");
        outputHelper.printWarning("warning");
        return outputHelper.wrapInfo(text) + " " + from + " " + to;
    }
}
