package com.novihub.shift.parser.impl.antlr4.providers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.shift.general.Utils;
import com.novihub.shift.parser.impl.antlr4.NodeManager;
import com.novihub.shift.parser.impl.antlr4.NodeProvider;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.ArgumentsContext;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.PredicateContext;
import com.novihub.shift.predicate.DictionaryPredicate;

public class PredicateProvider implements NodeProvider {
	
	private final NodeManager manager;
	
	public PredicateProvider(final NodeManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean isValid(ParseTree t) {
		return t instanceof PredicateContext;
	}

	@Override
	public LogicalNode<LocalDate> transform(ParseTree t) {
		final ParseTree method = t.getChild(0);
		
		final List<String> args = new ArrayList<>();
		
		if (t.getChildCount() == 4) {
			final ArgumentsContext arguments = (ArgumentsContext) t.getChild(2);
			args.addAll(arguments.children.stream()
					.map(a -> a.getChild(0).getText())
					.collect(Collectors.toList())
				);
		}
		
		final Method m = DictionaryPredicate.supplyPredicateFactory(method.getText(), args);
		if (m == null) {
			throw new RuntimeException("Dictionary can't find correct predicate");
		}
		
		try {
			
			Object[] arguments = new Object[args.size()];
			
			for (int i = 0; i < m.getParameterCount(); i++) {
				Parameter p = m.getParameters()[i];
				arguments[i] = Utils.convertString(p, args.get(i));				
			}
			
			return (LogicalNode<LocalDate>) m.invoke(null, arguments);
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("Dictionary can't find correct predicate", e); 
		}
	}

}
