/*
 * MethodBody.java
 *
 * Copyright (c) 2013 Mike Strobel
 *
 * This source code is subject to terms and conditions of the Apache License, Version 2.0.
 * A copy of the license can be found in the License.html file at the root of this distribution.
 * By using this source code in any fashion, you are agreeing to be bound by the terms of the
 * Apache License, Version 2.0.
 *
 * You must not remove this notice, or any other, from this software.
 */

package com.strobel.assembler.ir;

import com.strobel.assembler.Collection;
import com.strobel.assembler.metadata.ParameterDefinition;
import com.strobel.assembler.metadata.VariableDefinitionCollection;
import com.strobel.core.Freezable;

import java.util.List;

/**
 * @author mstrobel
 */
public final class MethodBody extends Freezable {
    private final InstructionCollection _instructions;
    private final VariableDefinitionCollection _variables;
    private final Collection<ExceptionHandler> _exceptionHandlers;

    private ParameterDefinition _thisParameter;
    private int _maxStackSize;
    private int _maxLocals;
    private int _codeSize;

    public MethodBody() {
        _instructions = new InstructionCollection();
        _variables = new VariableDefinitionCollection();
        _exceptionHandlers = new Collection<>();
    }

    public final InstructionCollection getInstructions() {
        return _instructions;
    }

    public final VariableDefinitionCollection getVariables() {
        return _variables;
    }

    public final List<ExceptionHandler> getExceptionHandlers() {
        return _exceptionHandlers;
    }

    public final ParameterDefinition getThisParameter() {
        return _thisParameter;
    }

    public final int getMaxStackSize() {
        return _maxStackSize;
    }

    public final int getCodeSize() {
        return _codeSize;
    }

    public final int getMaxLocals() {
        return _maxLocals;
    }

    final void setThisParameter(final ParameterDefinition thisParameter) {
        _thisParameter = thisParameter;
    }

    final void setMaxStackSize(final int maxStackSize) {
        _maxStackSize = maxStackSize;
    }

    final void setCodeSize(final int codeSize) {
        _codeSize = codeSize;
    }

    final void setMaxLocals(final int maxLocals) {
        _maxLocals = maxLocals;
    }

    @Override
    protected final void freezeCore() {
        _instructions.freezeIfUnfrozen();
        _variables.freezeIfUnfrozen();
        _exceptionHandlers.freezeIfUnfrozen();

        super.freezeCore();
    }
}
