package br.loja.testes;

import static org.junit.Assert.assertTrue;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.Timeout;

import br.loja.testes.rules.LoggingRule;

public class RulechainTest {
	
	@ClassRule
	public static Timeout timeout = new Timeout(1);

	@Rule
	public RuleChain chain = RuleChain.outerRule(new LoggingRule("rule 1")).around(new LoggingRule("rule 2"))
			.around(new LoggingRule("rule 3"));

	@Test
	public void example() {
		assertTrue(true);
	}
}
