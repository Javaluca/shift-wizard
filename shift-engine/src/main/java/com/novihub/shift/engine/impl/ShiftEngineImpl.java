package com.novihub.shift.engine.impl;

import java.time.LocalDate;
import java.util.List;

import com.novihub.logical.tree.LogicalTree;
import com.novihub.shift.engine.ShiftEngine;
import com.novihub.shift.general.Utils;

public class ShiftEngineImpl implements ShiftEngine {
	
	private final LogicalTree<LocalDate> tree;
	private LocalDate start;
	private LocalDate end;
	
	public ShiftEngineImpl(LogicalTree<LocalDate> tree) {
		if (tree == null) {
			throw new IllegalArgumentException("Invalid logical tree");
		}
		this.tree = tree;
	}
	
	public ShiftEngineImpl start(LocalDate start) {
		this.start = start;
		return this;
	}
	
	public ShiftEngineImpl end(LocalDate end) {
		this.end = end;
		return this;
	}

	@Override
	public List<LocalDate> evaluate() {
		return Utils.streamBetweenDates(this.start, this.end)
				.filter(tree)
				.toList();
	}

}
