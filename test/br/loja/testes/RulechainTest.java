package br.loja.testes;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

import br.loja.testes.rules.LoggingRule;

public class RulechainTest {

	@Rule
	public RuleChain chain = RuleChain.outerRule(new LoggingRule("rule 1")).around(new LoggingRule("rule 2"))
			.around(new LoggingRule("rule 3"));

	@Test
	public void example() {
		assertTrue(true);
	}
}
