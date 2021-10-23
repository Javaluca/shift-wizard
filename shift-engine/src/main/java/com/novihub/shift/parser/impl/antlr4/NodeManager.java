package com.novihub.shift.parser.impl.antlr4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;

public class NodeManager {
	
	private List<NodeProvider> providers;
	
	public NodeManager() {
		this.providers = new ArrayList<>();
	}
	
	public NodeManager addProvider(NodeProvider provider) {
		if (provider == null) {
			throw new IllegalArgumentException("Provider in input non valido");
		}
		
		this.providers.add(provider);
		return this;
	}
	
	public LogicalNode<LocalDate> transform(final ParseTree t) {
		for (NodeProvider nodeProvider : providers) {
			if (!nodeProvider.isValid(t)) {
				continue;
			}
			
			return nodeProvider.transform(t);
		}
		throw new RuntimeException("Not valid parse tree");
	}
	

}
