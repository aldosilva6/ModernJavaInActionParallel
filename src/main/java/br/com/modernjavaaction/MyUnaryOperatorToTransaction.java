package br.com.modernjavaaction;

import java.util.function.UnaryOperator;

import br.com.modernjavaaction.model.Transaction;

public class MyUnaryOperatorToTransaction implements UnaryOperator<Transaction> {

	@Override
	public Transaction apply(Transaction t) {
		String code = t.getReferenceCode();
		t.setReferenceCode(code.toUpperCase());
		return t;
	}

}
