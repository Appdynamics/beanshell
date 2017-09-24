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
package bsh;

import java.io.PrintStream;
import java.io.Reader;

/**
 * The capabilities of a minimal console for BeanShell.
 * Stream I/O and optimized print for output.
 *
 * A simple console may ignore some of these or map them to trivial
 * implementations. e.g. print() with color can be mapped to plain text.
 *
 * @see bsh.util.GUIConsoleInterface
 */
public interface ConsoleInterface {

    /**
     * Gets the in.
     *
     * @return the in
     */
    public Reader getIn();

    /**
     * Gets the out.
     *
     * @return the out
     */
    public PrintStream getOut();

    /**
     * Gets the err.
     *
     * @return the err
     */
    public PrintStream getErr();

    /**
     * Println.
     *
     * @param o
     *            the o
     */
    public void println(Object o);

    /**
     * Prints the.
     *
     * @param o
     *            the o
     */
    public void print(Object o);

    /**
     * Error.
     *
     * @param o
     *            the o
     */
    public void error(Object o);
}
