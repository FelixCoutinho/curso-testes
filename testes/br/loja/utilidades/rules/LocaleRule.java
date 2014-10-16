package br.loja.utilidades.rules;

import java.util.Locale;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class LocaleRule implements TestRule {  
  
    private static final Locale defaultLocale = Locale.getDefault();  
    private final Locale locale;  
  
    public LocaleRule(Locale locale) {  
        this.locale = locale;  
    }  
  
    @Override  
    public Statement apply(final Statement base, Description description) {  
        return new Statement() {  
            @Override  
            public void evaluate() throws Throwable {  
                Locale.setDefault(locale); // altera o locale padrão  
                try {  
                    base.evaluate(); // executa o teste  
                } finally {  
                    Locale.setDefault(defaultLocale); // volta o locale inicial  
                }  
            }  
        };  
    }  
}  