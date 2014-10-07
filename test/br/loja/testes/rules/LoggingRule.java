package br.loja.testes.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class LoggingRule implements TestRule {

	private final String string;

	public LoggingRule(String string) {
		this.string = string;
	}

	@Override
	public Statement apply(final Statement statement, Description description) {
		return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                try {
                	System.out.println(string);
                	statement.evaluate();
                } finally {
                    after();
                }
            }
        };
	}

	protected void after() {
		System.out.println("depois");
	}

	protected void before() {
		System.out.println("antes");
	}

}
