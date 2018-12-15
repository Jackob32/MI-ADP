/*
 * Copyright (c) 2018 Jakub Trhlík.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jakub Trhlík - initial API and implementation and/or initial documentation
 */
package strategy;

import strategy.IMoveStrategy;

/**
 *
 * @author Jakub Trhlík
 */
public class ParabolicMoveStrategy implements IMoveStrategy {

    @Override
    public int nextPositionY(int initY, float initAngle, float initForce, long lifetime) {
        return (int)(initY +(initForce * lifetime * Math.sin(initAngle)) + lifetime*lifetime/1000);
    }

    @Override
    public int nextPositionX(int initX, float initAngle, float initForce, long lifetime) {
        return (int)(initX +(initForce * lifetime * Math.cos(initAngle)));
    }

    
}
