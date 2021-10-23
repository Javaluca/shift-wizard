package com.novihub.shift.parser.impl.antlr4;

import java.time.LocalDate;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.LogicalTree;
import com.novihub.shift.parser.impl.AbstractLocalDateParser;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.ParseContext;

public class AntlrLocalDateParser extends AbstractLocalDateParser {
	
	private final NodeManager manager;
	
	public AntlrLocalDateParser(final NodeManager manager) {
		this.manager = manager;
	}

	@Override
	public LogicalTree<LocalDate> parse(String expression) {
		final ParseContext pc = this.parseContext(expression);
		
		return this.transform(pc.getChild(0));
	}
	
	private ParseContext parseContext(String expression) {
		CharStream stream = CharStreams.fromString(expression);
		SimpleBooleanLexer lexer = new SimpleBooleanLexer(stream);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
	
		SimpleBooleanParser sbp = new SimpleBooleanParser(tokens);
		
		return sbp.parse();
	}
	
	private LogicalTree<LocalDate> transform(final ParseTree pc) {
		
		
		final LogicalNode<LocalDate> root = this.manager.transform(pc);
		return LogicalTree.createTree(root);
	}
	
}
