package com.legadi.fuga.repl.config;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.jline.PromptProvider;

import com.legadi.fuga.repl.shell.OutputHelper;

@Configuration
public class ShellConfig {

    @Bean
    public PromptProvider promptProvider() {
        return () -> new AttributedString("fuga:>");
    }

    @Bean
    public OutputHelper outputHelper(@Lazy Terminal terminal) {
        return new OutputHelper(terminal);
    }
}
