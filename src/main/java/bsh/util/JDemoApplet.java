/*****************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one                *
 * or more contributor license agreements.  See the NOTICE file              *
 * distributed with this work for additional information                     *
 * regarding copyright ownership.  The ASF licenses this file                *
 * to you under the Apache License, Version 2.0 (the                         *
 * "License"); you may not use this file except in compliance                *
 * with the License.  You may obtain a copy of the License at                *
 *                                                                           *
 *     http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                           *
 * Unless required by applicable law or agreed to in writing,                *
 * software distributed under the License is distributed on an               *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY                    *
 * KIND, either express or implied.  See the License for the                 *
 * specific language governing permissions and limitations                   *
 * under the License.                                                        *
 *                                                                           *
 *                                                                           *
 * This file is part of the BeanShell Java Scripting distribution.           *
 * Documentation and updates may be found at http://www.beanshell.org/       *
 * Patrick Niemeyer (pat@pat.net)                                            *
 * Author of Learning Java, O'Reilly & Associates                            *
 *                                                                           *
 *****************************************************************************/
package bsh.util;

import java.awt.BorderLayout;

import javax.swing.JApplet;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.TargetError;

/**
 * Run bsh as an applet for demo purposes.
 */
public class JDemoApplet extends JApplet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** {@inheritDoc} */
    @Override
    public void init() {
        final String debug = this.getParameter("debug");
        if (debug != null && debug.equals("true"))
            Interpreter.DEBUG = true;
        final String type = this.getParameter("type");
        if (type != null && type.equals("desktop"))
            // start the desktop
            try {
                new Interpreter().eval("desktop()");
            } catch (final TargetError te) {
                te.printStackTrace();
                System.out.println(te.getTarget());
                te.getTarget().printStackTrace();
            } catch (final EvalError evalError) {
                System.out.println(evalError);
                evalError.printStackTrace();
            }
        else {
            this.getContentPane().setLayout(new BorderLayout());
            final JConsole console = new JConsole();
            this.getContentPane().add("Center", console);
            final Interpreter interpreter = new Interpreter(console);
            new Thread(interpreter).start();
        }
    }
}
